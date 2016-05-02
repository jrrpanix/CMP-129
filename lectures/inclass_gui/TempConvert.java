package gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class TempConvert extends JFrame {

	private JTextField _text;
	private JLabel     _result;
	
	public TempConvert() {
		super("F to C Converter");
		this.setSize(300,100);
		this.setLocation(500,200);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		buildInner();
		this.setVisible(true);
	}
	
	private void buildInner() {
		JPanel panel = new JPanel();
		_text = new JTextField(10);
		panel.add(_text);
		JButton button = new JButton("Calculate");
		button.addActionListener(new ButtonPressed());
		button.setForeground(Color.GREEN);
		panel.add(button);
		panel.add(_result = new JLabel("    "));
		panel.setBackground(Color.WHITE);
		this.add(panel);
	}
	
	public double toC( double F) {
		return (F - 32.0) * 5.0/9.0;
	}
	
	private class ButtonPressed implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			double C = toC( Double.parseDouble(_text.getText()));
			_result.setText(Double.toString(C));
			
		}
		
	}
	
	
	
	
	
	
	public static void main( String [] args ) {
		new TempConvert ();
	}
}
