import java.io.*;
import java.util.*;
import java.awt.*;

import javax.swing.*;

public class PriceTable extends JFrame {

    public PriceTable() {
    }
    
    public void read( String file ) {
	hist = new ArrayList<Record>();
	try {
	    File f = new File(file);
	    Scanner scan = new Scanner(f);
	    boolean isFirst = true;
	    while(scan.hasNextLine()) {
		String line = scan.nextLine();
		if ( isFirst ) {
		    isFirst = false;
		    continue;
		}
		String [] fields =  line.split(",");
		//System.out.println(line + " " + fields.length);
		if ( fields.length < 7) continue;
		Record r = new Record();
		int i = 0;
		r.date = fields[i++];
		r.open = Double.parseDouble(fields[i++]);
		r.high = Double.parseDouble(fields[i++]);
		r.low = Double.parseDouble(fields[i++]);
		r.close = Double.parseDouble(fields[i++]);
		r.volume = Long.parseLong(fields[i++]);
		r.adjclose = Double.parseDouble(fields[i++]);
		hist.add(r);
	    }
	    scan.close();
	} catch (IOException e) {
	    System.out.println(e);
	}
    }
    
    public String [] getColNames() {
	String [] cols = {"Date","Open","High","Low","Close","Volume","AdjClose" };
	return cols;
    }
    
    public String [] [] getData() {
	String [][] d = new String[hist.size()][7];
	for( int i = 0; i < hist.size(); i++) {
	    Record r = hist.get(i);
	    int j =0;
	    d[i][j++] = r.date;
	    d[i][j++] = Double.toString(r.open);
	    d[i][j++] = Double.toString(r.high);
	    d[i][j++] = Double.toString(r.low);
	    d[i][j++] = Double.toString(r.close);
	    d[i][j++] = Long.toString(r.volume);
	    d[i][j++] = Double.toString(r.adjclose);
	}
	return d;
    }
    
    public void buildGUI() {
	JTable table = new JTable( getData() , getColNames());
	JScrollPane scroll = new JScrollPane(table);
	add(scroll,BorderLayout.CENTER);
	setSize(700,600);
	setVisible(true);
    }
    
    public void report() {
	for( Record r : hist )
	    System.out.println(r);
    }

    public class Record {
	String date;
	double open;
	double high;
	double low;
	double close;
	long   volume;
	double adjclose;
	
	public String toString() {
	    return new String( date +"," + open + "," + high + "," + low + "," + close + "," +volume + "," +adjclose);
	}
    }
    
    public ArrayList<Record> hist;
    
    //====================================================
    // test 
    //=====================================================
    public static void main( String [] args ){
	String file = args.length == 0 ? "C:/Users/John/workspace/GUI/src/google_prices.csv" : args[0];
	PriceTable reader = new PriceTable();
	reader.read(file);
	reader.buildGUI();
    }
}
