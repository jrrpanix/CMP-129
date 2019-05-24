package sort;


public class quick {
	
	public static void sort( int [] A) {
		sort_(A,0,A.length-1);
	}
	
	private static void sort_(int [] A , int b , int e) {
		if ( b >=e)return;
		int p = partition_(A,b,e);
		sort_(A,b,p);
		sort_(A,p+1,e);
	}
	
	private static int partition_(int [] A , int b , int e) {
		int pivot =(b+e)/2;
		int D = A[pivot];
		int i = b-1;
		int j = e+1;
		while(true){
			while(A[++i]<D);
			while(A[--j]>D);
			if (i>=j) break;
			int t = A[i];
			A[i]=A[j];
			A[j]=t;
		}
		return j;
	}
	
}
