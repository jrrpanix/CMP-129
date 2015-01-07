
public class StopWatch1 {
    
    private long start_;
    private long stop_;


    public long MICRO_PER_NANO = 1000;
    public double SEC_PER_NANO = 1000000000.0;

    StopWatch1() {
	start_=stop_=0;
    }

    void start() {
	stop_=0;
	start_= System.nanoTime();
    }

    void stop() {
	stop_= System.nanoTime();
    }


    long timens() {
	return stop_ - start_;
    }

    long timeus() {
	return timens() / MICRO_PER_NANO;
    }

    double timesec() {
	return timens() / SEC_PER_NANO;
    }

    long getStart() {
	return start_;
    }

    long getStop() {
	return stop_;
    }


}