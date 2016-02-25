package stock_trader;

public class PriceCalc {
	private final Stock _stock;
	private double      _high;
	private double      _low;
	
	public PriceCalc( final Stock stock ) {
		_stock=stock;
	}
	
	public Stock getStock(){
		return _stock;
	}
	
	public double getHigh() {
		return _high;
	}
	
	public double getLow() {
		return _low;
	}
	
	public void calc( double [] prices ) {
		calcRange(prices);
	}
	
	private  void calcRange( double []prices) {
		if ( prices.length == 0) return ;
		_low= prices[0];
		_high=_low;
		for( int i = 1 ; i < prices.length ; i++) {
			double p = prices[i];
			if ( p > _high) _high = p;
			if ( p < _low ) _low =p;
		}
	}
	
}
