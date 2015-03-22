// Course      : CMP-129
// Title       : Class to hold StockPrices for the day
// Instructor  : JReynolds

import java.util.Date;
import java.text.SimpleDateFormat;

public class StockPrices {

    private Date   date_;
    private double open_;
    private double high_;
    private double low_;
    private double close_;
    private long   volume_;
    private double adjClose_;
    private static SimpleDateFormat dateFmt = new SimpleDateFormat( "yyyy-MM-dd");

    public StockPrices() {
	open_=0;
	high_=0;
	low_=0;
	close_=0;
	volume_=0;
	adjClose_=0;
    }

    public void parse( String line ) {
	String [] f  = line.split(",");
	int i = 0;
	if ( i < f.length ) date_=parseDate(f[i++]);
	if ( i < f.length ) open_ = Double.parseDouble(f[i++]);
	if ( i < f.length ) high_ = Double.parseDouble(f[i++]);
	if ( i < f.length ) low_ = Double.parseDouble(f[i++]);
	if ( i < f.length ) close_ = Double.parseDouble(f[i++]);
	if ( i < f.length ) volume_ = Long.parseLong(f[i++]);
	if ( i < f.length ) adjClose_ = Double.parseDouble(f[i++]);
	//System.out.println( "date=" + date_ +":high_=" + high_ + ":adjclose" + adjClose_ );
    }

    private Date parseDate( String dateString ) {
	try {
	    return dateFmt.parse(dateString);
	} 
	catch( java.text.ParseException e ) {
	    return new Date();
	}
    }

    public Date getDate() {
	return date_;
    }

    public double getOpen() {
	return open_;
    }

    public double getHigh() {
	return high_;
    }

    public double getLow() {
	return low_;
    }

    public double getClose() {
	return close_;
    }

    public long   getVolume() {
	return volume_;
    }

    public double getAdjClose() {
	return adjClose_;
    }

    

}