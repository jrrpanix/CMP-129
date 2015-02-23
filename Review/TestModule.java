import java.util.ArrayList;
import java.util.Scanner;

public class TestModule {

    // print
    public static void print( Object ... objects ) {
	for( int i = 0; i < objects.length ; i++ ) {
	    System.out.print(objects[i] + " " );
	}
	System.out.println("");
    }

    public static void StringExample() {
	print("");
	print("\nString Example");
	String [] Fruits = ArrayReview.GetFruits();
	ArrayReview.print(Fruits);
	print("First Element is",ArrayReview.getFirst(Fruits));
	print("Last  Element is",ArrayReview.getLast(Fruits));
	int ix = ArrayReview.find( Fruits , "Pear" );
	if ( ix != -1 ){
	    print( Fruits[ix],"is at index",new Integer(ix));
	}

    }

    public static void IntExample() {
	print("\nInt Example");
	int [] A = ArrayReview.GetInts();
	ArrayReview.print(A);
	print("First Element is",new Integer(ArrayReview.getFirst(A)));
	print("Last  Element is",new Integer(ArrayReview.getLast(A)));
	print("Max Value is" ,  new Integer( ArrayReview.max(A)));
	int halfLen = A.length/2;
	int ix = ArrayReview.find( A , A[halfLen] );
	print( new Integer( A[halfLen]),"is at index",new Integer(ix),"halfLen index is",new Integer(halfLen));
    }


    public static void SwapExample() {
	int [] A = {0,1};
	print ("");
	print("Swap Example ... Array Before Swap");
	ArrayReview.print(A);
	ArrayReview.Swap(A,0,1);
	print("Swap Example ... Array After Swap");
	ArrayReview.print(A);
    }


    public static void ForEachLoop( String [] A ) {
	print ("\nEnhanced For Loop Example");
	for( String s : A ) {
	    System.out.println("Element: " + s );
	}
    }


    public static void BoundsError() {
	print("\nTesting Bounds Error");
	try {
	    int [] A = {1,2,3};
	    int ix = -1;
	    System.out.println(A[ix]);
	}
	catch (java.lang.ArrayIndexOutOfBoundsException e ) {
	    System.out.println(e);
	}
    }

    public static void MultiArray() {
	print ("\n2D Array");
	int [][] X = new int[2][3];
	print( new Integer( X.length) , "X" ,new Integer(X[0].length));
	ArrayReview.init(X);
	ArrayReview.print(X);
	int [][] Y = { {1,2}, {3,4} , {5,6} , {7,8}};
	print("");
	print( new Integer( Y.length) , "X" ,new Integer(Y[0].length));
	ArrayReview.print(Y);
    }


    public static void ArrayListTest() {
	print("\nArrayList");
	ArrayList<String> inputList = new ArrayList<String>();
	Scanner input = new Scanner(System.in);
	while( input.hasNext() ) {
	    String nxt = input.next();
	    if ( nxt.equals("quit") )break;
	    inputList.add(nxt);
	}
	input.close();
	for( String a :inputList ) {
	    print(a);
	}
	for( int i =0; i < inputList.size() ; i++ ) {
	    if (inputList.get(i).equals("fox") ) {
		print("found fox!");
		break;
	    }
	}
    }

    // main
    public static void main( String [] args ) {
	print( "Begin Test Module ..." );
	StringExample();
	IntExample();
	SwapExample();
	ForEachLoop(ArrayReview.GetFruits());
	BoundsError();
	MultiArray();
	ArrayListTest();
	print( "\nEnd Test Module ..." );
    }

}
