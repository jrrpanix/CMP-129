package sort;

public class merge {

	public static boolean InPlace = false;
	
	static public void sort( int [] A) {
		int [] buffer = new int[A.length];
		_sort(A,0,A.length-1,buffer);
	}
	
	static private void _sort(int [] A , int b , int e,int[] buffer) {
		int mid =(b+e)/2;
		if ( b == e) return;
		_sort(A,b,mid,buffer);
		_sort(A,mid+1,e,buffer);
		_merge(A,b,mid,e,buffer);
	}
	
	static private void _merge( int [] A , int b , int m , int e, int [] buffer) {
		_mergeCopy(A,b,m,e,buffer);
	}
	
	static private void _mergeCopy( int [] A , int b , int m , int e, int [] X) {
		int i = b;
		int j =m+1;
		int k=0;
		int XL = e-b+1;
		while( i <= m && j <= e) {
			if ( A[i] < A[j]) {
				X[k++]=A[i++];
			} else {
				X[k++]=A[j++];
			}
		}
		while( i <= m) X[k++]=A[i++];
		while( j<=e) X[k++]=A[j++];
		for( int l =0; l < XL; l++) {
			A[b++]=X[l];
		}	
	}
	
	static public void _mergeInPlace( int [] A , int b , int m , int e) {
		int i = b;
		int j =m+1;
		while( i <= m && j <= e) {
			if ( A[i] < A[j]) {
				i++;
			} else {
				_swap(A,i,j);
				for(int k=j+1 ; k<=e ;k++) {
					if (A[k]<A[k-1]) _swap(A,k,k-1);
					else break;
				}
			}
		}
	}
	
	
	
	static private void _swap( int [] A , int i , int j) {
		int t = A[i];
		A[i]=A[j];
		A[j]=t;
	}
	
	
	static public void main( String [] args ) {
		int trials= 100;
		int size = 1600;
		int [] A = shuffel.Range(size);
		for( int i =0 ; i < trials; i++) {
			shuffel.Shuffel(A);
			sort(A);
			if ( !shuffel.check(A)) {
				System.out.println("failed");
				return;
			}
		}
		System.out.println("passed:trials=" + trials +":size=" +size);
	}
	
}
