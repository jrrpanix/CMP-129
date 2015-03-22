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
	prices_= new ArrayList<StockPrices>();
    }

    public String getSymbol() {
	return symbol_;
    }

    public void add( StockPrices price ) {
	prices_.add(price);
    }

    public StockPrices get( int i ) {
	return prices_.get(i);
    }

    public ArrayList<StockPrices> getPrices() {
	return prices_;
    }

    public int getMaxPrice() {
	if ( prices_.size() == 0) return -1;
	int ix = 0;
	double mx = prices_.get(ix).getAdjClose();
	for( int i = 1 ; i < prices_.size();i++ ){
	    if ( prices_.get(i).getAdjClose() > mx ) {
		mx = prices_.get(i).getAdjClose();
		ix=i;
	    }
	}
	return ix;
    }

    public int getMinPrice() {
	if ( prices_.size() == 0) return -1;
	int ix = 0;
	double mx = prices_.get(ix).getAdjClose();
	for( int i = 1 ; i < prices_.size();i++ ){
	    if ( prices_.get(i).getAdjClose() < mx ) {
		mx = prices_.get(i).getAdjClose();
		ix=i;
	    }
	}
	return ix;
    }

}