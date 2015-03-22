// Course      : CMP-129
// Title       : Class to hold stock price history
// Instructor  : JReynolds

import java.util.ArrayList;

public class StockHistory {

    private String symbol_;
    private ArrayList<StockPrices> prices_;
    

    public StockHistory() {
    }

    public StockHistory( String symbol ) {
	symbol_=symbol;
    }

    public String getSymbol() {
	return symbol_;
    }

    public void add( StockPrices price ) {
	prices_.add(price);
    }

    public ArrayList<StockPrices> getPrices() {
	return prices_;
    }

}