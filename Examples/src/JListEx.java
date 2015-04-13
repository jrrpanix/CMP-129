import javax.swing.*;
import java.awt.*;
import javax.swing.event.*;

public class JListEx extends JFrame {

    private String [] months =  {"JAN","FEB","MAR","APR","MAY","JUN","JUL","AUG","SEP","OCT","NOV","DEC"};
    private JTextField mSel;
    private JList<String> monthl;

    public JListEx() {
	initFrame();
	initList();
	pack();
	setVisible(true);
    }

    private void initFrame() {
	setTitle( "List Example");
	setSize( 550, 400 );
	setLocation( 200,200);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
    }


    private void initList() {
	JPanel lp = new JPanel();
	lp.setLayout( new BorderLayout());
	monthl = new JList<String>(months);
	monthl.setSelectionMode( ListSelectionModel.SINGLE_SELECTION);
	monthl.addListSelectionListener( new ListL());
	monthl.setVisibleRowCount(5);
	JScrollPane scroll = new JScrollPane(monthl);
	lp.add(scroll,BorderLayout.CENTER);
	mSel = new JTextField(10);
	mSel.setEditable(false);
	lp.add(mSel,BorderLayout.PAGE_END);
	add(lp);
    }

    private class ListL implements ListSelectionListener {
	public void valueChanged( ListSelectionEvent e ) {
	    String sel = (String)monthl.getSelectedValue();
	    mSel.setText(sel);
	}
    }

    public static void main( String [] args ){
	new JListEx();
    }
					     

}


