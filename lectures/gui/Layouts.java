package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Layouts extends JFrame {

	private JPanel _panel;
	
	public Layouts(String layout ,int x ,int y) {
		super("Layout " + layout);
		setSize(500,300);
		setLocation(x,y);
		_panel = new JPanel();
		if ( layout.equals("flow")) {
			setFlow();
		} else if ( layout.equals("border") ){
			setBorder();
		} else if ( layout.equals("grid")) {
			setGrid();
		}
		add(_panel);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	private void setFlow() {
		int alignment=FlowLayout.CENTER;
		int hgap = 15;
		int vgap =75;
		_panel.setLayout(new FlowLayout(alignment,hgap,vgap));
		_panel.add(new JButton("One"));
		_panel.add(new JButton("Two"));
		_panel.add(new JButton("Three"));
	}
	
	private void setBorder() {
		_panel.setLayout( new BorderLayout());
		_panel.add(new JButton(BorderLayout.NORTH),BorderLayout.NORTH);
		_panel.add(new JButton(BorderLayout.SOUTH),BorderLayout.SOUTH);
		_panel.add(new JButton(BorderLayout.EAST),BorderLayout.EAST);
		_panel.add(new JButton(BorderLayout.WEST),BorderLayout.WEST);
		_panel.add(new JButton(BorderLayout.CENTER),BorderLayout.CENTER);
	}
	
	
	private void setGrid() {
		_panel.setLayout(new GridLayout(4,3));
		String [] labels = { "1","2","3",
		                     "4","5","6",
		                     "7","8","9",
		                     "*","0","#"};
		for( int i =0 ; i < labels.length ;i++) {
			_panel.add(new JButton(labels[i]));
		}
		
		
	}
	
	public static void main( String [] args ) {
		new Layouts("flow",600,200);
		new Layouts("border",700,300);
		new Layouts("grid",800,400);
	}
	
}
