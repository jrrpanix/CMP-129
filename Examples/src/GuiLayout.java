import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class GuiLayout extends JFrame {
	JPanel panel;
	JLabel label;
	JTextField text;
	JButton button;
	JButton eButton;
	JRadioButton rButton;
	
	public GuiLayout(String lOption ) {
		super("Example GUI " + lOption + " Layout");
		buildFrame();
		initComponents();
		if (lOption.equals("No")){
			noLayout();
		} else if ( lOption.equals("Flow")) {
			flowLayout();
		} else if ( lOption.equals("Border")) {
			borderLayout();
		} else if (lOption.equals("Grid")){
			gridLayout();
		}
		setVisible(true);
	}
	
	private void gridLayout() {
		panel.setLayout(new GridLayout(3,2));
		panel.add(label);
		panel.add(text);
		panel.add(button);
		panel.add(rButton);
		panel.add(eButton);
		add(panel);
	}
	
	private void noLayout() {
		panel.add(label);
		panel.add(text);
		panel.add(button);
		panel.add(rButton);
		add(panel);
	}
	
	private void flowLayout() {
		panel.setLayout(new FlowLayout());
		panel.add(label);
		panel.add(text);
		panel.add(button);
		panel.add(rButton);
;		add(panel);
	}
	
	private void borderLayout() {
		panel.setLayout( new BorderLayout());
		panel.add(label, BorderLayout.NORTH);
		panel.add(text,BorderLayout.CENTER);
		panel.add(button,BorderLayout.WEST);
		panel.add(rButton,BorderLayout.SOUTH);
		panel.add(eButton,BorderLayout.EAST);
		add(panel);
	}
	
	private void buildFrame() {
		setSize(400,200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(200,200);
	}
	
	private void initComponents() {
		label = new JLabel("Input:");
		text = new JTextField(10);
		button = new JButton("Calculate");
		eButton = new JButton( "Exit");
		rButton = new JRadioButton("CacheOn");
		panel = new JPanel();
		
	}
	
	public static void main( String [] args ){
		new GuiLayout("No");
		new GuiLayout("Flow");
		new GuiLayout("Border");
		new GuiLayout("Grid");
	}
	
}
;