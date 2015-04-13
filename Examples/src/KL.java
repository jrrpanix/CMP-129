import javax.swing.*;
import java.awt.*;
import java.awt.event.*;



public class KL extends JFrame {

    JTextField xInput;
    JTextField yInput;
    JTextField result;

    public KL() {
	super("A Calculator");
	initFrame();
	initInput();
	pack();
	setVisible(true);
    }

    private void initFrame() {
	setSize( 500, 100 );
	setLocation( 200,200);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void initInput() {
	JPanel inputP = new JPanel();
	inputP.add( new JLabel( "X" ));
	xInput = new JTextField( 10 );
	xInput.addKeyListener( new KeyL());
	inputP.add(xInput);
	inputP.add( new JLabel( "Y" ));
	yInput = new JTextField( 10 );
	yInput.addKeyListener( new KeyL());
	inputP.add(yInput);
	result = new JTextField(10);
	result.setEditable(false);
	inputP.add(result);
	add(inputP);
    }

    private class KeyL implements KeyListener{
	public void keyPressed( KeyEvent e){
	}
	
	public void keyTyped( KeyEvent e) {
	}
	public void keyReleased( KeyEvent e) {
	    updateResult();
	}
	
	public void printComponent( KeyEvent e ) {
	    Component c = e.getComponent();
	    if ( c.equals(xInput)) {
		System.out.println("was x");
	    }
	    if ( c.equals(yInput)) {
		System.out.println("was y");
	    }
	}
    }
    
    private double getDouble( String text ) {
	try {
	    return Double.parseDouble(text);
	}
	catch( Exception e ) {
	    return 0;
	}
    }
    
    private void updateResult() {
	double x = getDouble( xInput.getText() );
	double y = getDouble( yInput.getText() );
	result.setText( Double.toString(x+y));
	//System.out.println( "x = " + x + " y = " + y );
    }

    public static void main( String [] args ){
	new KL();
    }

}