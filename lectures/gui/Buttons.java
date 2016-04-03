package gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Buttons extends JFrame{

	JButton [] _buttons;
	JPanel     _panel;
	JLabel     _label;
	
	public Buttons(int N) {
		super("Buttons");
		setSize(200,600);
		setLocation(700,200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		createButtons(N);
		addLabel();
		setVisible(true);
	}
	
	private void createButtons(int N ) {
		_panel = new JPanel();
		_buttons = new JButton[N];
		for( int i = 0; i < N ; i++) {
			_buttons[i] = new JButton( "Button :" + i);
			_buttons[i].addActionListener(new ButtonPressed());
			_panel.add(_buttons[i]);
		}
		_panel.add(new JButton(""));
		add(_panel);
	}
	
	private void addLabel() {
		_label = new JLabel("     ");
		_panel.add(_label);
		
	}
	
	private class ButtonPressed implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			_label.setText(e.getActionCommand());
			Object source = e.getSource();
			if ( source instanceof JButton) {
				JButton b = (JButton)source;
				Color c = b.getForeground();
				if ( c.equals(Color.RED)) {
					b.setForeground(Color.CYAN);
				} else {
					b.setForeground(Color.RED);
				}
			}
		}
		
	}
	
	public static void main(String [] args ) {
		new Buttons(4);
	}
	
	
	
}
