mport javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FrontPanel extends JFrame{
    
    JPanel []    panels;
    PanelStuff[] stuff;
    
    final int nRows = 1;
    final int nCols = 3;
    final int WIDTH = 300;
    final int HEIGHT = 200;

    public FrontPanel() {
	super("FrontPanel");
	init();
	initPanel();
	buildPanel(panels[0],stuff[0],0);
	buildPanel(panels[1],stuff[1],1);
	buildPanel(panels[2],stuff[2],2);
	setVisible(true);
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



