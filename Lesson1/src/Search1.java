
public class Search1 {

    // 
    public static int binarySearch( int [] A , int value ) {
	int b = 0 , e = A.length-1;
	while ( b <= e ) {
	    int i = (e + b) /2;
	    if ( A[i] == value ) return i;
	    if ( A[i] < value ) b = i+1;
	    else e = i -1 ;
	}
	return -1;
    }

    public static void print( int [] A ) {
	for( int a : A ) System.out.print( a + " " );
	System.out.println( "");
    }

    public static void searchPrint( int [] A , int value ) {
	int ix = binarySearch( A , value );
	if ( ix == -1 )
	    System.out.println( "unable to find value " + value );
	else
	    System.out.println( "searching value " + value + " found at " + ix + " value = " + A[ix] );
    }

    public static void testSearch() {
	int [] A = Random1.createInt( 10 , 1000 );
	Sort1.selectionSort(A);
	print(A);
	searchPrint(A,A[5]);
	searchPrint(A,A[0]);
	searchPrint(A,A[A.length-1]);
	searchPrint(A,-1000);
	searchPrint(A,20000);
    }

    public static void main( String[] args ) {
	testSearch();
    }

}