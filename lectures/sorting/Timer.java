package sort;

public class Timer {

	private long _start;
	private long _stop;
	
	public void start() {
		_stop=0;
		_start = System.nanoTime();
	}
	
	public void stop() {
		_stop = System.nanoTime();
	}
	
	public long elapsed() {
		return _stop - _start;
	}
	
	public long getStart() {
		return _start;
	}
	
	public long getStop() {
		return _stop;
	}
	
}
