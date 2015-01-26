// course  :CMP-129
// example : Introdution to Java Gui's
// author  : JReynolds (adaptation from Gaddis Chapter 12)

import javax.swing.*;

import java.awt.Color;
import java.awt.event.*;

public class Gui1 extends JFrame {

    // Example GUI in JAVA with No Layout Manager! 
    // This is a slightly different take on what was done in the text
    // Gaddis Chapter 12.
    // 
    
    // Create a class that extends from JFrame
    public Gui1() {
	build();
    }
    
    public static double getMiles( double kilometers ) {
	return kilometers * 0.6214;
    }
    
    //-----------------------------------------------------
    private void build() {
	
	// Set initial parameters for the frame
	setTitle("Kilometer Converter");
	setSize(W, H);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	// build the panel
	buildPanel();
	
	// add the panel to the frame
	add(panel_);
	
	// make it visible
	setVisible(true);
    }
    
    private void buildPanel() {
	// the panel will have 4 items
	label_ = new JLabel( "Enter Kilometers");
	kText_ = new JTextField(10);
	calcButton_ = new JButton("Calc Kilometers!");
	result_ = new JLabel();
	
	// we add code to deal with the button being pressed
	calcButton_.addActionListener(new ButtonListener());
	calcButton_.setBackground(Color.RED);
	
	// for fun set the foreground color on the result to white
	result_.setForeground(Color.WHITE);
	
	// create the panel add all of the components we created to it
	panel_ = new JPanel();
	panel_.add( label_);
	panel_.add(kText_);
	panel_.add(calcButton_);
	panel_.add(result_);
	panel_.setBackground(Color.GREEN);
    }
    
    //-----------------------------------------------------
    // private class members 
    // note we put a trailing underscore "_" so it makes it easy to identify member variables!
    //--------------------------------------------------------
    private JPanel panel_;
    private JLabel label_;
    private JTextField kText_;
    private JButton calcButton_;
    private JLabel result_;
    private final int H = 450;
    private final int W = 300;
    
    //-------------------------------------------------------
    // Event Handling Class
    //-------------------------------------------------------
    class ButtonListener implements ActionListener {
	
	// when the button is pressed grab the text
	// convert it to a double get the result
	// and write it to the result_ text area
	public void actionPerformed( ActionEvent e){
	    String input = kText_.getText();
	    System.out.println( "Text entered=" + input);
	    Double kilo = Double.valueOf(input);
	    System.out.println( );
	    result_.setText("Miles = " + getMiles(kilo));
	}
    }
    
    
    
    //-----------------------------------------------------
    public static void main(String[] args) {
	new Gui1();
    }
    

}
