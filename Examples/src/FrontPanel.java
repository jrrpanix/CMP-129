import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FrontPanel extends JFrame{
    
    JPanel []    panels;
    PanelStuff[] stuff;
    JMenuBar menuBar;
    JMenu    menu,submenu;
    JMenuItem menuItem;
    JRadioButtonMenuItem rbMenuItem;
    JCheckBoxMenuItem cbMenuItem;
    
    final int nRows = 1;
    final int nCols = 3;
    final int WIDTH = 300;
    final int HEIGHT = 200;

    public FrontPanel() {
	super("FrontPanel");
	init();
	//oMenu();
	initPanel();
	buildMenu();
	buildPanels();
	setVisible(true);
    }
    
    public void oMenu() {
	//Create the menu bar.
	menuBar = new JMenuBar();

	//Build the first menu.
	menu = new JMenu("A Menu");
	menu.setMnemonic(KeyEvent.VK_A);
	menu.getAccessibleContext().setAccessibleDescription(
							     "The only menu in this program that has menu items");
	menuBar.add(menu);

	//a group of JMenuItems
	menuItem = new JMenuItem("A text-only menu item",
				 KeyEvent.VK_T);
	menuItem.setAccelerator(KeyStroke.getKeyStroke(
						       KeyEvent.VK_1, ActionEvent.ALT_MASK));
	menuItem.getAccessibleContext().setAccessibleDescription(
								 "This doesn't really do anything");
	menu.add(menuItem);

	menuItem = new JMenuItem("Both text and icon",
				 new ImageIcon("images/middle.gif"));
	menuItem.setMnemonic(KeyEvent.VK_B);
	menu.add(menuItem);

	menuItem = new JMenuItem(new ImageIcon("images/middle.gif"));
	menuItem.setMnemonic(KeyEvent.VK_D);
	menu.add(menuItem);

	//a group of radio button menu items
	menu.addSeparator();
	ButtonGroup group = new ButtonGroup();
	rbMenuItem = new JRadioButtonMenuItem("A radio button menu item");
	rbMenuItem.setSelected(true);
	rbMenuItem.setMnemonic(KeyEvent.VK_R);
	group.add(rbMenuItem);
	menu.add(rbMenuItem);

	rbMenuItem = new JRadioButtonMenuItem("Another one");
	rbMenuItem.setMnemonic(KeyEvent.VK_O);
	group.add(rbMenuItem);
	menu.add(rbMenuItem);

	//a group of check box menu items
	menu.addSeparator();
	cbMenuItem = new JCheckBoxMenuItem("A check box menu item");
	cbMenuItem.setMnemonic(KeyEvent.VK_C);
	menu.add(cbMenuItem);

	cbMenuItem = new JCheckBoxMenuItem("Another one");
	cbMenuItem.setMnemonic(KeyEvent.VK_H);
	menu.add(cbMenuItem);

	//a submenu
	menu.addSeparator();
	submenu = new JMenu("A submenu");
	submenu.setMnemonic(KeyEvent.VK_S);

	menuItem = new JMenuItem("An item in the submenu");
	menuItem.setAccelerator(KeyStroke.getKeyStroke(
						       KeyEvent.VK_2, ActionEvent.ALT_MASK));
	submenu.add(menuItem);

	menuItem = new JMenuItem("Another item");
	submenu.add(menuItem);
	menu.add(submenu);

	//Build second menu in the menu bar.
	menu = new JMenu("Another Menu");
	menu.setMnemonic(KeyEvent.VK_N);
	menu.getAccessibleContext().setAccessibleDescription(
							     "This menu does nothing");
	menuBar.add(menu);

	//
	setJMenuBar(menuBar);
    }
    
    public void buildPanels() {
	//buildPanel(panels[0],stuff[0],0);
	buildPanel(panels[1],stuff[1],1);
	buildPanel(panels[2],stuff[2],2);
    }
    
    public void buildMenu() {
	//JPanel panel = panels[0];
	menuBar = new JMenuBar();
	//menuBar.setAlignmentX(TOP_ALIGNMENT);
	//menuBar.setAlignmentY(TOP_ALIGNMENT);
	menuBar.setBounds(50, 50, 50, 50);
	//menuBar.setSize(300,200);
	menu = new JMenu( "File       ");
	menu.setMnemonic(KeyEvent.VK_A);
	menuBar.add(menu);
	menuItem = new JMenuItem( "Text Only Item",KeyEvent.VK_T);
	menu.add(menuItem);
	add(menuBar);
	setJMenuBar(menuBar);
    }
    
    public void init() {
	setSize(WIDTH,HEIGHT);
	setLayout(new GridLayout(3,1));
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void initPanel() {
	panels = new JPanel[nCols];
	stuff = new PanelStuff[nCols];
	for( int i = 0; i < panels.length ;i++) {
	    panels[i] = new JPanel();
	    stuff[i] = new PanelStuff();
	}
    }
    
    public void buildPanel( JPanel panel , PanelStuff pstuff , int ix) {
	pstuff.button = new JButton( "Button" + ix);
	pstuff.button.addActionListener(new ButtonListener());
	pstuff.label = new JLabel( "Label" + ix);
	pstuff.textField = new JTextField(10);
	panel.add(pstuff.button);
	panel.add(pstuff.label);
	panel.add(pstuff.textField);
	add(panel);
    }
    
    class PanelStuff {
	JButton    button;
	JLabel     label;
	JTextField textField;
    }
    
    class ButtonListener implements ActionListener{
	public void actionPerformed( ActionEvent e) {
	    String cmd = e.getActionCommand();
	    String text = stuff[0].textField.getText();
	    String msg = null;
	    if( cmd.equals("Button0")) {
		msg = " you pressed Button0";
	    }
	        
	    if ( text.length() == 0 ) {
		msg += new String(", no text entered");
	    }
	    else {
		msg += new String(", amazing job you entered :" + text);
	    }
	    JOptionPane.showMessageDialog(null,msg);
	    System.out.println("ActionCmd="+e.getActionCommand()+":id="+e.getID());
	        
	}
    }
    
    
    public static void main(String [] args ) {
	FrontPanel p = new FrontPanel();
	
    }
}
