import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.Random;

public class FallingShapes extends JPanel {

    private Timer timer_;
    private int delayms_;
    private Random rand_;
    private int r_;
    private int nb_;
    private int [] xpos_ ;
    private int [] ypos_ ;
    private int [] shape_;
    private Color [] color_;
    private int dx_;
    private int dy_;

    public FallingShapes() {
	init();
	setBackground(Color.white);
    }

    private void init() {
	rand_ = new Random();

	r_=25;
	nb_=7;
	dx_=0;
	dy_=55;
	xpos_=new int[nb_];
	ypos_=new int[nb_];
	shape_ = new int[nb_];
	color_ = new Color[nb_];
	Color [] ColorSel = { Color.red,Color.orange,Color.yellow,Color.blue,Color.green,Color.cyan,Color.magenta };
	int gap = 75;
	for( int i = 0; i < xpos_.length ; i++ ) {
	    ypos_[i]=0;
	    if ( i == 0 ) xpos_[i] = 0;
	    else xpos_[i] = xpos_[i-1] + dx_ + gap;
	    shape_[i] = i % 2 + 1;
	    System.out.println(i + " " + (i%2) );
	    int j = i % ColorSel.length;
	    color_[i] = ColorSel[j];
	}

	delayms_ = 500;
	timer_ = new Timer( delayms_ , new TimerL() );
	timer_.start();
    }

    
    public void paintComponent(Graphics g ) {
	super.paintComponent(g);
	drawShapes(g);
    }

    private void drawShapes(Graphics g) {
	for( int i = 0; i < xpos_.length ; i++ ) {
	    int shape = shape_[i];
	    switch( shape ) {
	    case 1 :
		drawOval(g,i);
		break;
	    case 2:
		drawRect(g,i);
		break;
	    default:
		drawOval(g,i);
	    }
	}
    }

    private void drawOval( Graphics g, int i ) {
	g.setColor(color_[i]);
	int x = xpos_[i] , y = ypos_[i];
	g.fillOval(x,y,r_*2,r_*2);
    }

    private void drawRect( Graphics g, int i ) {
	g.setColor(color_[i]);
	int x = xpos_[i] , y = ypos_[i];
	g.fillRect(x,y,r_*2,r_*2);
    }

    private void moveShapes() {
	for( int i = 0; i < xpos_.length ; i++ ) {
	    if ( dy_ > 0 )
		ypos_[i] += rand_.nextInt(dy_);
	    checkYBound(i);
	    if ( dx_ > 0 )
		xpos_[i] += rand_.nextInt(dx_);
	    checkXBound(i);
	}
	repaint();
    }

    private void checkXBound( int i ) {
	Dimension d = getSize();
	if ( xpos_[i] > d.width ) xpos_[i] = 0;
    }

    private void checkYBound( int i ) {
	Dimension d = getSize();
	if ( ypos_[i] > d.height ) ypos_[i] = 0;
    }

    private class TimerL implements ActionListener {
	public void actionPerformed( ActionEvent e ) {
	    moveShapes();
	}
    }

    static public void Run() {
	JFrame frame = new JFrame("Falling Shapes" );
	frame.setSize(500,500);
	frame.setLocation(200,200);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.add( new FallingShapes());
	frame.setVisible(true);
    }

    static public void main(String [] args ) {
	Run();
    }

}

