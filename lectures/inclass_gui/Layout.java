package gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Layout extends JFrame {
	JPanel     _keyPanel;
	JPanel     _outerPanel;
	JTextField _result;
	
	public Layout() {
		super("Telephone");
		setSize(400,400);
		setLocation(500,200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		createPanels();
		setVisible(true);
	}
	
	private void createPanels() {
		_outerPanel = new JPanel();
		_outerPanel.setLayout( new BorderLayout());
		_result = new JTextField(15);
		createKeys();
		
		_outerPanel.add(_result,BorderLayout.NORTH);
		_outerPanel.add(_keyPanel, BorderLayout.CENTER);
		add(_outerPanel);
	}
	
	private void createKeys() {
		_keyPanel = new JPanel();
		_keyPanel.setLayout(new GridLayout(4,3));
		String [] keys = { "1","2","3",
						   "4","5","6",
						   "7","8","9",
						   "*","0","#" };
		JButton button = null;
		ActionListener listener = new ButtonPressed();
		for( int i = 0; i < keys.length;i++) {
			_keyPanel.add(button=new JButton(keys[i]));
			button.addActionListener(listener);
		}
	}
	
	private class ButtonPressed implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			_result.setText(_result.getText()+e.getActionCommand());
		}
	}
	
	public static void main( String [] args ) {
		new Layout();
	}
	
}
