package sort;
import java.util.Random;



public class shuffel {
	
	public static int [] RandA(int len) {
		Random r = new Random();
		int [] X = new int[len];
		for( int i =0; i < X.length;i++) {
			X[i]=i;
		}
		for( int i =0; i < 3*len/2 ; i++) {
			int k = r.nextInt(len);
			int j = r.nextInt(len);
			int tmp = X[k];
			X[k]=X[j];
			X[j]=tmp;
		}
		return X;
		
	}
	
	
	public static void print(int [] X) {
		for( int i=0;i < X.length;i++) System.out.format( "%d ", X[i]);
		System.out.format("\n");
	}
	
}
