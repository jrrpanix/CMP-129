package sort;

public class Test {

	
	public static void results( String algo , int trials , int size , long elapsed ) {
		System.out.format("%10s %10d %10d %20d\n",algo,trials,size,elapsed);
	}
	
	public static void testQuick(int trials , int size) {
		Timer timer = new Timer();
		timer.start();
		for( int i =0; i < trials; i++ ) {
			int [] A = shuffel.RandA(size);
			quick.sort(A);
		}
		timer.stop();
		results("quick",trials,size,timer.elapsed());
		
	}
	
	public static void testSelection(int trials , int size) {
		Timer timer = new Timer();
		timer.start();
		for( int i =0; i < trials; i++ ) {
			int [] A = shuffel.RandA(size);
			selection.sort(A);
		}
		timer.stop();
		results("selection",trials,size,timer.elapsed());
			
	}

	public static void main(String [] args) {
		int trials=1;
		int [] N = {10000,100000,1000000};
		for( int i =0;i < N.length;i++) {
			testQuick(trials,N[i]);
			testSelection(trials,N[i]);
		}
	}
	
}
