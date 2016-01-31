package intro;

import java.util.Random;

public class Pyramid {

	
	public static int [][] create(int N, int seed) {
		Random rand = new Random(seed);
		int [][]X = new int[N][];
		for( int i =0; i < N ;i++) {
			int [] Z = new int[i+1];
			setRandom(Z,rand);
			X[i]= Z;
		}
		return X;
	}
	
	public static void setRandom( int [] Z , Random rand) {
		for ( int i =0;i < Z.length; i++) {
			Z[i] = rand.nextInt(100);
		}
	}
	
	public static void print( int [][] X) {
		for( int i =0; i < X.length; i++) {
			print(X[i]);
		}
	}
	
	public static void print( int [] X) {
		for( int i =0;i < X.length;i++) {
			System.out.format("%d ", X[i]);
		}
		System.out.println();
	}
	
	public static void main(String [] args) {
		int [][] X = create(5,1001);
		print(X);
	}
	
}
