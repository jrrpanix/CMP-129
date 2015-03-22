import java.net.URL;
import java.net.URLConnection;
import java.net.HttpURLConnection;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Date;
import java.text.SimpleDateFormat;

public class StockURLReader {

    private static SimpleDateFormat dateFmt = new SimpleDateFormat( "yyyy-MM-dd");    
    private static SimpleDateFormat yearFmt = new SimpleDateFormat("yyyy");
    private static SimpleDateFormat monthFmt = new SimpleDateFormat("MM");
    private static SimpleDateFormat dayFmt = new SimpleDateFormat("dd");

    public static StockHistory GetHistory( String symbol , Date begin , Date end ) {
	String urlString = formUrl( symbol, begin ,end );
	StockHistory history = new StockHistory( symbol );
	try {
	    URL url = new URL( urlString );
	    URLConnection conn = url.openConnection();
	    HttpURLConnection httpConn = null;
	    if ( conn instanceof HttpURLConnection ) {
		httpConn = (HttpURLConnection)conn;
	    }
	    else {
		return history;
	    }
	    BufferedReader in = new BufferedReader( new InputStreamReader(httpConn.getInputStream()));
	    String line = null;
	    long count = 0;
	    while( (line = in.readLine()) != null ) {
		if ( count++ == 0 ) continue;
		StockPrices prices = new StockPrices();
		prices.parse(line);
		System.out.println(line);
		history.add(prices);
	    }
	}
	catch( IOException e ) {
	    System.out.println(e);
	}
	return history;
    }

    public static String formUrl( String symbol , Date begin ,Date end ) {
	String l = getHost();
	l += "s=" + symbol;
	l += "&d=" + (GetMonth(end)-1);
	l += "&e=" + GetDay(end);
	l += "&f=" + GetYear(end);
	l += "&a=" + (GetMonth(begin)-1);
	l += "&b=" + GetDay(begin);
	l += "&c=" + GetYear(begin);
	return l;
    }


    public static String getHost() {
	return "http://real-chart.finance.yahoo.com/table.csv?";
    }

    public static Date GetDate( String dateString ) {
	try {
	    return dateFmt.parse(dateString);
	} 
	catch( java.text.ParseException e ) {
	    return new Date();
	}
    }

    public static int GetYear( Date d ) {
	return Integer.parseInt( yearFmt.format(d));
    }

    public static int GetMonth( Date d ) {
	return Integer.parseInt( monthFmt.format(d));
    }
    public static int GetDay( Date d ) {
	return Integer.parseInt( dayFmt.format(d));
    }

    //---------------------------------------------------------------
    // main
    //---------------------------------------------------------------
    public static void main( String [] args ) {
	Date d = GetDate("2015-03-22");
	int yyyy = GetYear(d);
	int mm = GetMonth(d);
	int dd = GetDay(d);
	System.out.println( yyyy + " " + mm + " " + dd );
	System.out.println( formUrl( "GOOGL" , GetDate("2014-01-01") , GetDate("2015-03-22") ) );
	GetHistory( "GOOGL" , GetDate("2014-01-01") , GetDate("2015-03-22") );
    }

}