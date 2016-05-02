package gui;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class DistanceConvert extends JFrame {

	JTextField _input;
	JLabel     _resultLabel;
	JLabel     _output;
	String     _units;
	
	public DistanceConvert() {
		super("Distance Converter");
		setLocation(500,200);
		setSize(400,200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		build();
		setVisible(true);
	}
	
	private void build() {
		
		ActionListener rblistener = new RBListener();
		JRadioButton kilos = new JRadioButton("miles",true);
		_units="miles";
		kilos.addActionListener(rblistener);
		JRadioButton miles = new JRadioButton("feet");
		miles.addActionListener(rblistener);
		JRadioButton inches = new JRadioButton("inches");
		inches.addActionListener(rblistener);
		ButtonGroup group = new ButtonGroup();
		group.add(kilos);
		group.add(miles);
		group.add(inches);
		JPanel buttonP = new JPanel();
		buttonP.setLayout(new GridLayout(1,3));
		buttonP.add(kilos);
		buttonP.add(miles);
		buttonP.add(inches);


		JPanel inputP = new JPanel();
		inputP.add(new JLabel("enter value in kilometers"));
		_input = new JTextField(6);
		_input.addKeyListener(new KiloKeyListener());
		inputP.add(_input);
	
		JPanel outputP = new JPanel();
		_resultLabel = new JLabel(_units);
		outputP.add(_resultLabel);
		_output = new JLabel("           ");
		outputP.add(_output);
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(3,1));
		panel.add(inputP);
		panel.add(outputP);
		panel.add(buttonP);
		add(panel);
	}
	
	
	
	private void calculate() {
		double kilos=0;
		try {
			kilos = Double.parseDouble(_input.getText());
		} catch (Exception e) {
			kilos=0;
		}
		double convert=0;
		if ( _units.equals("miles"))
			convert = kilos * 0.6214;
		else if (_units.equals("feet"))
			convert = kilos * 3281.0;
		else 
			convert = kilos * 3281 * 12.0;
		_output.setText(Double.toString(convert));
		_resultLabel.setText(_units);
	}
	
	private class KiloKeyListener implements KeyListener {

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			Character  c = e.getKeyChar();
			int value = (int)c.charValue();
			if ( value ==10) calculate();
			//System.out.println("keytyped=" + value + ":code=" + e.getKeyCode() +":");
			
		}

		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	private class RBListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println(e.getActionCommand());
			_units=e.getActionCommand();
			calculate();
			
		}
		
	}
	
	
	
	public static void main(String [] args ) {
		new DistanceConvert();
	}
}
