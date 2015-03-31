import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.*;

public class StringEntryView extends JFrame{
	JPanel     panel;
	JTextField text;
	JLabel     label;
	
	public StringEntryView() {
		super("String Entry Example");
		initFrame();
		build();
		setVisible(true);
	}
	
	private void build() {
		panel = new JPanel();
		label  = new JLabel( "Word:");
		text = new JTextField(15);
		panel.add(label);
		panel.add(text);
		add(panel);
		text.addActionListener(new TextListener());
		text.addKeyListener(new TextKeyListener());
	}
	class TextListener implements ActionListener{
		public void actionPerformed( ActionEvent e) {
			JOptionPane.showMessageDialog(text,new String("Text:" +text.getText()));
		}
	}
	
	class TextKeyListener implements KeyListener{
		public void keyPressed( KeyEvent e){
			summarizeAction(e,"Pressed");
		}
		
		public void keyTyped( KeyEvent e) {
			summarizeAction(e,"Typed");
		}
		
		public void keyReleased( KeyEvent e) {
			summarizeAction(e,"Released");
		}
		
		public void summarizeAction( KeyEvent e, String a){
			System.out.println( "you +" + a + " " + e.getKeyChar());
		}
	}
	
	private void initFrame() {
		int width = 275, height= 75;
		setSize(width,height);
		setLocation(500,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String [] args ){
		StringEntryView view = new StringEntryView();
	}
	
}
