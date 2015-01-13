// Course      : CMP-129
// Title       : Examples of Java ArrayList
// Instructor  : JReynolds

import java.util.ArrayList;
import java.util.Iterator;

class ArrayListExample {

    public static void iterateList( ArrayList<String> A ) {
	for( Iterator<String> it = A.iterator() ; it.hasNext() ; ) {
	    System.out.println( it.next() );
	}
    }

    public static ArrayList<String> copyArgs( String [] args ) {
	ArrayList<String> A = new ArrayList<String>();
	for( String a : args )
	    A.add(a);
	return A;
    }

    public static void main( String [] args ) {
	ArrayList<String> A = copyArgs(args);
	iterateList( A);
    }

}