public class ArrayReview {

    // print string array
    static void print( String [] args ) {
	System.out.print("[");
	for( int i = 0; i < args.length ; i++ ) {
	    if ( i != 0 ) System.out.print(",");
	    System.out.print(args[i]);
	}
	System.out.println("]");
    }

   static void print( int [] args ) {
	System.out.print("[");
	for( int i = 0; i < args.length ; i++ ) {
	    if ( i != 0 ) System.out.print(",");
	    System.out.print(args[i]);
	}
	System.out.println("]");
    }

    // find greatest value
    static int max( int [] A ) {
	if ( A.length == 0 ) return 0;
	int maxv = A[0];
	for( int i =1 ; i < A.length ; i++ ) {
	    if ( A[i] > maxv ) maxv = A[i];
	}
	return maxv;
    }

    static int find( int [] A , int X ) {
	for( int i = 0; i < A.length ; i++ ) {
	    if ( A[i] == X  ) return i;
	}
	return -1;
    }

    static int find( String [] A , String pattern ) {
	for( int i = 0; i < A.length ; i++ ) {
	    if ( A[i].equals(pattern) ) return i;
	}
	return -1;
    }

    static String getFirst( String [] A ) {
	return A[0];
    }

    static int getFirst( int [] A ) {
	return A[0];
    }

    static String getLast( String [] A ) {
	return A[A.length-1];
    }

    static int getLast( int [] A ) {
	return A[A.length-1];
    }


    static void Swap( int [] A , int i , int j ) {
	int tmp = A[i];
	A[i] = A[j];
	A[j] = tmp;
    }

    public static String [] GetFruits() {
	String [] Fruits = {"Apple","Banana","Pear","Peach","Blueberry","Strawberry","Kiwi"};
	return Fruits;
    }


    public static int [] GetInts() {
	int [] A = {100,22,101,33,35,78,22,99,21,15};
	return A;
    }


}
