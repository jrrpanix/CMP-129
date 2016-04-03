package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TempConvert extends JFrame {

	private JTextField _temp;
	private JLabel     _result;
	
	public TempConvert(String title ) {
		super(title);
		this.setSize(600,600);
		this.setLocation(700,200);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		calcPanel();
		this.setVisible(true);
	}
	
	private void calcPanel() {
		JPanel panel = new JPanel();	
		JLabel label = new JLabel("Enter temperature F:");
		_temp = new JTextField(6);
		JButton button = new JButton("calc");
		button.addActionListener(new CalcListener());
		_result = new JLabel("     ");
		
		panel.add(label);
		panel.add(_temp);
		panel.add(button);
		panel.add(_result);
		this.add(panel);
	}
	
	static private double toC( double F) {
		return (F-32.0)*5.0/9.0;
	}
	
	private class CalcListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			double F = Double.parseDouble(_temp.getText());
			double C = toC(F);
			_result.setText(Double.toString(C));
		}
		
	}
	
	
	public static void main(String [] args) {
		new TempConvert("Simple Temperature Converter");
	}
	
	
}
