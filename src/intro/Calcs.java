package intro;

public class Calcs {

	public static int add( int x1 , int x2) {
		return x1 + x2;
	}
	
	public static int sub( int x1 , int x2) {
		return x1 + x2;
	}
	
	public static int add( String x1 , String x2) {
		return Integer.parseInt(x1) + Integer.parseInt(x2);
	}
	
	public static int sub( String x1 , String x2) {
		return Integer.parseInt(x1) - Integer.parseInt(x2);
	}
	
	public static int sum( int [] X) {
		int t=0;
		for( int i =0;i < X.length ; i++) {
			t += X[i];
		}
		return t;
	}
	
	public static int [] toInts( String [] args, int start) {
		int [] X  = new int[args.length - start];
		for( int i =start; i < args.length; i++) {
			X[i-start]=Integer.parseInt(args[i]);
		}
		return X;
	}

}
