// Course      : CMP-129
// Title       : Sort Algorithms (Selection Sort)
// Instructor  : JReynolds

class Sort1 {

    // 
    //  implementation of selection sort algorithm
    //  selection sort works as follows
    //  
    //  start at position i=0 in array size N
    //  find the smallest value in array (position j) in range position i to N-1
    //  swap i and j 
    //  increment to position i+1 
    //  stop when position i == N-1
    // 
    public static void selectionSort( int [] A) {
	// go down array and swap i with the indexOfMin
	for( int i = 0; i < A.length - 1 ; i++) {
	    swap( A , i , indexOfMin(A,i));
	}
    }

    //
    // private implmentation details of selectionSort
    //

    private static int indexOfMin( int [] A , int pos) {
	// find the index of the min value from pos to end of array
	// return that index
	// Note: This is 'private' because its part of the algorithm implementation
	int m = pos;
	for( int i = pos + 1 ; i < A.length ; i++ )
	    if ( A[i] < A[m]) m = i;
	return m;
    }

    private static void swap( int [] A , int i , int j ) {
	// Swap array positions i and j
	// Note: This is 'private' because its part of the algorithm implementation
	int tmp = A[i];
	A[i]=A[j];
	A[j]=tmp;
    }
}