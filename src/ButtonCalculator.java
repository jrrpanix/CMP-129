package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ButtonCalculator extends JFrame{

	private JPanel _panel;
	private JPanel _panel0;
	private JPanel _panel1;
	private JLabel _result;
	
	public ButtonCalculator() {
		super("Calculator");
		setSize(300,300);
		setLocation(700,300);
		buildCalc();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	private void buildCalc() {
		_panel=new JPanel();
		_panel.setLayout(new BorderLayout());
		_panel0 = new JPanel();
		_panel1 = new JPanel();
		
		_panel.add(_panel0,BorderLayout.NORTH);
		_panel.add(_panel1,BorderLayout.CENTER);
		_panel0.add(_result = new JLabel(" "));
		_panel1.setLayout(new GridLayout(4,3));
		String [] labels = { "1","2","3",
							 "4","5","6",
							 "7","8","9",
							 "+","0","-"};
		ActionListener l = new ButtonPressed();
		for( int i =0; i < labels.length; i++) {
			JButton b = new JButton(labels[i]);
			b.addActionListener(l);
			_panel1.add(b);
		}
		add(_panel);
		
	}
	
	private class ButtonPressed implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String astr = e.getActionCommand();
			_result.setText(_result.getText()+astr);
		}
		
	}
	
	public static void main(String [] args ) {
		new ButtonCalculator();
	}
	
	
}
