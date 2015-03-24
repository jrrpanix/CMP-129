import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.geom.Line2D;

public class CalcGUI extends JFrame{
	private JPanel paneli_;
	private JPanel panelr_;
	private JLabel xmsg_;
	private JLabel ymsg_;
	private JTextField xval_;
	private JLabel yres_;
	private JButton calcB_;
	
	public CalcGUI() {
		setTitle("Calculator");
		setSize( 550, 700);
		setVisible(true);
		//setLayout(new FlowLayout(FlowLayout.CENTER,25,10));
		setLayout( new GridLayout(2,1));
		createPanel();
	}
	
	public void paint( Graphics g) {
		super.paint(g);
		System.out.println("in override");
		drawLines(g);
	}
	
	public void drawLines( Graphics g) {
		Graphics2D g2 =(Graphics2D)g;
		g2.drawLine(120, 400, 300, 400);
		g2.draw(new Line2D.Double(59.2d, 99.8d, 419.1d, 99.8d));

		g2.draw(new Line2D.Float(21.50f, 132.50f, 459.50f, 132.50f));
	}
	
	private void createPanel() {
		paneli_=new JPanel();
		xmsg_= new JLabel( "X:");
		
		calcB_= new JButton("Calc");
		calcB_.addActionListener(new CalcAction());
		xval_ = new JTextField(10);
		paneli_.add(xmsg_);
		paneli_.add(xval_);
		paneli_.add(calcB_);
		panelr_ = new JPanel();
		
		ymsg_= new JLabel( "Y:");
		yres_=new JLabel("0.00000000000000");
		panelr_.add(ymsg_);
		panelr_.add(yres_);
		//panelr_.add(new JLabel("                      "));
		
		
		add(paneli_);
		add(panelr_);
	}
	
	private class CalcAction implements ActionListener{
	
		public void actionPerformed( ActionEvent e){
			String data = xval_.getText();
			if ( data.length() > 0 ){
			double x = Double.parseDouble(data);
			double y = Math.exp(x);
			String ydata = Double.toString(y);
			yres_.setText(ydata);
			}
		}
	}
	
	public static void main( String [] args ){
		CalcGUI c = new CalcGUI();
		
	}
}
