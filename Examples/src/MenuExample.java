import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

public class MenuExample  extends JFrame {

	JFileChooser chooser;
	
	public MenuExample() {
		init();
		initMenu();
		setVisible(true);
	}
	
	private void initMenu() {
		JMenuBar menuBar = new JMenuBar();
		JMenu fileMenu = new JMenu( "File");
		JMenuItem openItem = new JMenuItem("Open");
		openItem.addActionListener( new MenuActionL());
		fileMenu.add(openItem);
		
		fileMenu.addSeparator();
		
		JMenuItem saveItem = new JMenuItem("Save");
		saveItem.addActionListener(new MenuActionL());
		fileMenu.add(saveItem);
		
		menuBar.add(fileMenu);
		setJMenuBar(menuBar);
		chooser = new JFileChooser();
		chooser.addActionListener(new FileL());
	}
	
	class FileL implements ActionListener {
		public void actionPerformed(ActionEvent e ) {
			String cmd = e.getActionCommand();
			if (cmd.equals("ApproveSelection")) {
				System.out.println("You selected " + chooser.getSelectedFile());	
			}
			
		}
	}
	
	class MenuActionL implements ActionListener {
		
		public void actionPerformed(ActionEvent e ) {
			String cmd = e.getActionCommand();
			if ( cmd.equals("Open")){
				openCmd();
			} else if ( cmd.equals("Save")) {
				saveCmd();
			}
		}
		
		private void openCmd() {
			System.out.println(" in openCmd()") ;
			getListing();
		}
		
		private void saveCmd() {
			System.out.println(" in saveCmd()") ;
		}
		
	}
	
	private void getListing() {
		chooser.showOpenDialog(getParent());
	}
	
	private void init() {
		setSize(300,500);
		setLocation(1600,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	static public void main( String [] args ){
		new MenuExample();
	}
	
}
