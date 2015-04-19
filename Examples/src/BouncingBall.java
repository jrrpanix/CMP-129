import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.Random;

public class BouncingBall extends JPanel {

    private Timer timer;
    private int timeDelayMS;
    private int count ;
    private int bDim;
    private int x,y;
    private boolean debug ;
    private Random rand;
    private boolean up;

    public BouncingBall() {
	init();
	timer.start();
    }

    
    public void paintComponent(Graphics g ) {
	super.paintComponent(g);
	g.setColor(Color.red);
	g.fillOval(x,y,bDim,bDim);
    }


    private void init() {
	timeDelayMS = 75;
	timer = new Timer( timeDelayMS , new TimerListener() );
	bDim=50;
	count = 0;
	x=100;
	y=100;
	debug=false;
	rand = new Random();
	up = true;
    }


    private void setY() {
	if ( up ) {
	    up = false;
	    y +=20;
	} else {
	    up = true;
	    y -= 20;
	}
    }

    private void setX() {
	x += 10;
	if ( x > 499 ) x=0;
    }

    private void randBounce() {
	int w = getWidth();
	int h = getHeight();
	x = rand.nextInt(w);
	y = rand.nextInt(h);
    }

    private void bounce() {
	if ( debug && count++ == 10 ) {
	    System.out.println( "Bounce ....");
	    count=0; 
	}
	setY();
	setX();
	repaint();
    }

    private class TimerListener implements ActionListener {
	public void actionPerformed( ActionEvent e ) {
	    bounce();
	}
    }

    static public void BounceBall() {
	JFrame frame = new JFrame();
	frame.setSize(500,500);
	frame.setLocation(1550,200);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.add( new BouncingBall());
	frame.setVisible(true);
    }

    static public void main(String [] args ) {
	BounceBall();
    }

}