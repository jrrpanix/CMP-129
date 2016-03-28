package sort;

public class Test {

	
	public static void results( String algo , int trials , int size , long elapsed ) {
		System.out.format("%25s %10d %10d %20d\n",algo,trials,size,elapsed);
	}
	
	public static void testQuick(int trials , int size , boolean randomize ) {
		Timer timer = new Timer();
		timer.start();
		int [] A = shuffel.Range(size);
		for( int i =0; i < trials; i++ ) {
			if (randomize)
				shuffel.Shuffel(A);
			quick.sort(A);
		}
		timer.stop();
		results("quick:random="+randomize,trials,size,timer.elapsed());
		
	}
	
	public static void testMerge(int trials , int size , boolean randomize ) {
		Timer timer = new Timer();
		timer.start();
		int [] A = shuffel.Range(size);
		for( int i =0; i < trials; i++ ) {
			shuffel.Shuffel(A);
			merge.sort(A);
		}
		timer.stop();
		results("merge",trials,size,timer.elapsed());
			
	}
	
	public static void testSelection(int trials , int size) {
		Timer timer = new Timer();
		timer.start();
		int [] A = shuffel.Range(size);
		for( int i =0; i < trials; i++ ) {
			shuffel.Shuffel(A);
			selection.sort(A);
		}
		timer.stop();
		results("selection",trials,size,timer.elapsed());
			
	}
	
	

	public static void main(String [] args) {
		int trials=20;
		int [] N = {10000,100001,1000000,2000000};
		for( int i =0;i < N.length;i++) {
			testQuick(trials,N[i],true);
			testMerge(trials,N[i],true);
			testQuick(trials,N[i],false);
			if ( N[i] <= 100000) {
				testSelection(trials/4,N[i]);
			}
			System.out.println("");
		}
		System.out.println("complete");
	}
	
}
