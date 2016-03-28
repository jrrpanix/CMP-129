package sort;
import java.util.Random;



public class shuffel {
	
	
	public static int [] Range(int len) {
		int [] X = new int[len];
		for( int i =0; i < X.length;i++) {
			X[i]=i;
		}
		return X;
	}
	
	public static void Shuffel(int [] X) {
		int len = X.length;
		Random r = new Random();
		for( int i =0; i < 3*len/2 ; i++) {
			int k = r.nextInt(len);
			int j = r.nextInt(len);
			int tmp = X[k];
			X[k]=X[j];
			X[j]=tmp;
		}		
	}
	
	static public boolean check( int [] A) {
		for( int i =1 ; i < A.length ;i++) {
			if ( A[i-1]> A[i] || A[i-1]+1 != A[i]) return false;
		}
		return true;
	}
	
	public static void print(int [] X) {
		for( int i=0;i < X.length;i++) System.out.format( "%d ", X[i]);
		System.out.format("\n");
	}
	
	public static void print(int [] X , int b, int e) {
		for( int i=b;i <= e;i++) System.out.format( "%d ", X[i]);
		System.out.format("\n");
	}
	
}
