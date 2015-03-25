//-------------------------------------------------
// course     : CMP-129
// instructor : JReynolds
// simple example of creating and putting some data into a JTable
//-------------------------------------------------

import javax.swing.*;
import java.awt.*;

public class SimpleJTable extends JFrame{

    public String [][] data_;
    public String []   colNames_;
    
    public SimpleJTable() {
	init();
	build();
    }
    
    public void init() {
	String [][] data = { {"John" , "973-123-4561" } ,
			     {"Alex" ,"212-456-1000" },
			     {"Alice" , "312-333-7890"}
	};
	String [] cols = { "Name" , "Number" };
	data_=data;
	colNames_=cols;
    }
    
    
    public void build() {
	JTable table = new JTable( data_ , colNames_);
	JScrollPane scroll = new JScrollPane(table);
	add(scroll,BorderLayout.CENTER);
	setSize(400,400);
	setVisible(true);
    }
    
    public static void main( String [] args ){
	SimpleJTable ex = new SimpleJTable();
    }
    
}
