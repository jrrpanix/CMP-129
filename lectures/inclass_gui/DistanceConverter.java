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

public class DistanceConverter extends JFrame{
	private JTextField _input;
	private JLabel     _units;
	private JLabel     _output;
	private String     _currentUnits;
	
	public DistanceConverter() {
		super("DistanceConverter");
		setSize(400,200);
		setLocation(400,200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		buildInner();
		setVisible(true);
	}
	
	private void buildInner() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(3,1));
		// build the panel content
		// top line label and textfield
		JLabel inputLabel = new JLabel("enter value in kilometers");
		_input = new JTextField(6);
		_input.addKeyListener(new InputKey());
		JPanel line1 = new JPanel();
		line1.add(inputLabel);
		line1.add(_input);
		
		// line 2 stuff here
		_units = new JLabel("miles");
		_output = new JLabel("    ");
		JPanel line2 = new JPanel();
		line2.add(_units);
		line2.add(_output);
		
		// line 3 the buttons
		JPanel line3 = new JPanel();
		ActionListener buttonListener = new ButtonSelected();
		JRadioButton miles = new JRadioButton("miles",true);
		miles.addActionListener(buttonListener);
		_currentUnits = "miles";
		
		JRadioButton feet = new JRadioButton("feet");
		feet.addActionListener(buttonListener);
		JRadioButton inches = new JRadioButton("inches");
		inches.addActionListener(buttonListener);
		ButtonGroup group = new ButtonGroup();
		group.add(miles);
		group.add(feet);
		group.add(inches);
		
		line3.add(miles);
		line3.add(feet);
		line3.add(inches);
		
		
		
		panel.add(line1);
		panel.add(line2);
		panel.add(line3);
		add(panel);
	}
	
	private void convert() {
		double kilometers = 0.0;
		try {
			kilometers = Double.parseDouble(_input.getText());
		} catch (Exception ex) {
			kilometers =0;
		}
		double convertValue = 0;
		if ( _currentUnits.equals("miles")) {
			convertValue = 0.6214 * kilometers;
		} else if ( _currentUnits.equals("feet")) {
			convertValue = 3281 * kilometers;
		}else if (_currentUnits.equals("inches")) {
			convertValue = 39372 * kilometers;
		}
		_output.setText(Double.toString(convertValue));
		
	}
	
	private class ButtonSelected implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			_currentUnits=e.getActionCommand();
			_units.setText(_currentUnits);
			convert();
		}
		
	}
	
	private class InputKey implements KeyListener {

		@Override
		public void keyPressed(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyTyped(KeyEvent e) {
			Character c = e.getKeyChar();
			int k = (int)c;
			if ( k != 10) return;
			convert();
			
		}
		
	}
	
	
	
	public static void main(String [] args ) {
		new DistanceConverter();
	}
	
}
