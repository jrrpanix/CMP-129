package stock_trader;

public class Stock {

	private final String _name;
	private final String _ticker;
	private final double _pe;
	
	
	public Stock( final String name , final String ticker , final double pe) {
		_name=name;
		_ticker=ticker;
		_pe=pe;
	}
	
	public String getName() {
		return _name;
	}
	
	public String getTicker() {
		return _ticker;
	}
	
	public double getPE() {
		return _pe;
	}

	
	
}
