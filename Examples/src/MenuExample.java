// CMP-129
// Example of Menu and FileChooser
// JReynolds

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

public class MenuExample  extends JFrame {

    JFileChooser  chooser;
    JTextArea     text;
    
    public MenuExample() {
	init();
	initMenu();
	initViewArea();
	setVisible(true);
    }
    
    private void initViewArea() {
	JPanel panel = new JPanel();
	text = new JTextArea("",25,65);
	
	text.setLineWrap(true);
	JScrollPane scroll = new JScrollPane(text);
	scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
	panel.add(scroll);
	add(panel);
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
    
    private void loadFile() {
	try {
	    File f = chooser.getSelectedFile();
	    FileInputStream fs = new FileInputStream(f);
	    DataInputStream ds = new DataInputStream(fs);
	    String contents = new String();
	    while( ds.available() > 0 ) {
		int n = ds.available();
		System.out.println(n + " bytes avail");
		byte [] buffer = new byte[n];
		ds.read(buffer);
		contents += new String(buffer);
	    }
	    text.setText(contents);
	    ds.close();
	} catch (IOException e) {
	    
	}
    }
    
    class FileL implements ActionListener {
	public void actionPerformed(ActionEvent e ) {
	    String cmd = e.getActionCommand();
	    if (cmd.equals("ApproveSelection")) {
		System.out.println("You selected " + chooser.getSelectedFile());
		loadFile();
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
	setSize(800,500);
	setLocation(1600,300);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    static public void main( String [] args ){
	new MenuExample();
    }
    
}
