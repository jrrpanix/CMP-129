package sort;

public class selection {

	public static void sort( int [] A) {
	
		for( int i =0; i < A.length;i++) {
			int mi = getMin(A,i);
			int tmp =A[mi];
			A[mi]=A[i];
			A[i]=tmp;
		}
		
	}
	
	private static int getMin(int [] A , int s) {
		int m = A[s];
		int mi = s;
		for( int i = s+ 1 ; i < A.length ; i++) {
			if ( A[i] < m ) {
				m = A[i];
				mi=i;
			}
		}
		return mi;
	}
	
	
}
