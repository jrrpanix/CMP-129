class Sort1 {

    private static int smallestIndex( int [] A , int pos) {
	int m = pos;
	for( int i = pos + 1 ; i < A.length ; i++ )
	    if ( A[i] < A[m]) m = i;
	return m;
    }

    private static void swap( int [] A , int i , int j ) {
	int tmp = A[i];
	A[i]=A[j];
	A[j]=tmp;
    }

    public static void selectionSort( int [] A) {
	for( int i = 0; i < A.length - 1 ; i++) {
	    swap( A , i , smallestIndex(A,i));
	}
    }

}