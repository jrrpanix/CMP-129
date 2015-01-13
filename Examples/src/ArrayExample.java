import java.util.Random;
import java.util.Arrays;

/***
    Text Book Reference Gaddis Chapter 7

    Motivation for arrays is to have a contiguous block of memory to hold
    multiple values of the same data typesaccess by a single variable name.
    The access of a Array can be Sequential or Random

    Sequential Access - start a beginning and then get the next element
    Random Access - get ith element
    

    Allows for development of  powerful algorithms (sorting,searching,dynamically incresing size)





 **/
class DateCalc {
    // Examples
    // 
    static public String [] Months = {"JAN","FEB","MAR","APR","MAY","JUN","JUL","AUG","SEP","OCT","NOV","DEC" };
    static public int [] Days = {31,28,31,30,31,30,31,31,30,31,30,31};
    static public String[] DaysOfWeek= { "Sunday", "Monday", "Tuesday" , "Wednesday" , "Thrusday" , "Friday" , "Saturday" };

    static public boolean isValidMonth( int Month ) {
	return (Month >= 1) && (Month <=12 );
    }

    static public boolean isLeapYear( int Year ) {
	return (( ( Year % 4 ) == 0 ) && (( Year % 100 ) != 0 )) || (( Year % 1000) == 0 );
    }

    static public int getDaysInMonth( int Month , int Year ) {
	if ( !isValidMonth(Month)) return -1; // invalid input
	int nDays = Days[Month-1];
	return ( Month == 2 && isLeapYear(Year) ) ? nDays +1 : nDays;
    }
    
    static public String getMonthAsString( int Month ) {
	return isValidMonth(Month) ? Months[Month-1] : new String();
    }
}

class IntCalc {

    // No Array World
    // If No Arrays, code woudl like like this .... many more variables needed to manage the same thing
    static public int addInt( int x0 , int x1 , int x2 , int x3 ) {
	return x0 + x1 + x2 + x3;
    }

    // Array World
    static public int add( int [] A ) {
	int sum = 0;
	for( int a : A ) sum += a;
	return sum;
    }

    // Dot Product
    static public double dotProduct( double [] theta , double [] X ) {
	double sum = 0;
	for( int i = 0; i < theta.length ; i++ ) {
	    sum += theta[i] * X[i];
	}
	return sum;
    }


    static public int [] copyRange( int [] A , int startIndex , int endIndex ) {
	int len = endIndex - startIndex + 1;
	int [] B = new int[len];
	for( int i = startIndex,j=0 ; i <= endIndex ; i++,j++ ) B[j] = A[i];
	return B;
    }


    static public void printArray( int [] A ) {
	for( int a : A ) System.out.print( a + " " );
	System.out.println("");
    }

}

class MultiDim {

    static public void print2D( double [] [] I ) {
	for( int i = 0; i < I.length ; i++ ) {
	    for( int j = 0; j < I[i].length; j++ )
		System.out.print( " " + I[i][j] );
	    System.out.println("");
	}
    }

    static public void print2D( String [] [] I ) {
	for( int i = 0; i < I.length ; i++ ) {
	    for( int j = 0; j < I[i].length; j++ )
		System.out.print( " " + I[i][j] );
	    System.out.println("");
	}
    }

    static public double [][]  twoByTwo() {
	double [] [] I = { { 1 , 0 } , {0, 1 } };
	return I;
    }

    static public double [][] create2D( int rows, int cols ) {
	double [] [] M = new double[rows][cols];
	return M;
    }

    static public double [][] createIdenity( int dim ) {
	double [][] M = create2D( dim , dim );
	for(int i = 0; i < dim ; i++ )
	    M[i][i] = 1;
	return M;
    }

    static public double [][] raggedDoubleArray( int [] colWidth ) {
	double [][] M = new double [colWidth.length][];
	for( int i = 0; i < colWidth.length ; i++ )
	    M[i] = new double[colWidth[i]];
	return M;
    }

    static public String [][] raggedString( int [] colWidth ) {
	String [][] M = new String [colWidth.length][];
	for( int i = 0; i < colWidth.length ; i++ )
	    M[i] = new String[colWidth[i]];
	return M;
    }


}


class ArrayExample {
    // Run Test Cases from the Above Classes

    static public void testOutOfBounds() {
	System.out.println( "-----------------------------------------------" );
	System.out.println( "Testing Array out of bounds will throw exception" );
	try {
	    // NOTE in Java an Array Can be declared as "int A[]" in addition to "int [] A"
	    int A[] = { 0 , 1, 2 };
	    int a = A[-1];
	    a++; // will never go to this line
	}
	catch( java.lang.ArrayIndexOutOfBoundsException e ) {
	    System.out.println( "Caught Exception " + e.toString() );
	}
    }

    static public void testMonths() {
	System.out.println( "-----------------------------------------------" );
	System.out.println("Testing Months as Strings");
	int [] months = { 3 , 5 , 11 , 13 };
	for( int m : months )
	    System.out.println( "month = " + m + " as string = " + DateCalc.getMonthAsString(m));
    }


    static public void testLeapYears() {
	System.out.println( "-----------------------------------------------" );
	System.out.println("Testing Leap Years" );
	int [] testYears = {1800,1804,1900,1901,1904,1964,1965,1984,2000,2001};
	for( int y : testYears ) {
	    System.out.println( "Days in Month for " + "Feb/" + y + " = " + DateCalc.getDaysInMonth(2,y)); 
	}
    }

    static public void testSystemArrayFunctions() {
	System.out.println( "-----------------------------------------------" );
	System.out.println("Testing Java Built in Array Functions" );
	// genrate array of size 10 of random numbers between 0 and 999
	int [] D = Random1.RandomIntArray( 10 , 1000 ); 
	Arrays.sort(D);
	IntCalc.printArray(D);
	int [] E = Arrays.copyOf( D, 5 );
	IntCalc.printArray(E);
	int [] F = new int[6];
	System.arraycopy(D,3,F,0,F.length);
	IntCalc.printArray(F);
    }


    static public void testMultiDim() {
	System.out.println( "-----------------------------------------------" );
	System.out.println("Testing MultiDimenstion Arrays" );
	MultiDim.print2D( MultiDim.twoByTwo());
	System.out.println( "Creating 3x3 Idenity Matrix");
	MultiDim.print2D( MultiDim.createIdenity(3));

	System.out.println( "Ragged Array Example");
	int [] cols = {  2, 3, 1 } ;
	String [][] Seating = MultiDim.raggedString(cols);
	Seating[0][0] = "Jessica" ;
	Seating[0][1] = "Tony" ;

	Seating[1][0] = "Bill" ;
	Seating[1][1] = "Tracy" ;
	Seating[1][2] = "Alex" ;

	Seating[2][0] = "Pat";
	MultiDim.print2D( Seating );
	
    }

    static public void main( String [] args ) {
	testOutOfBounds();
	testMonths();
	testLeapYears();
	testSystemArrayFunctions();
	testMultiDim();
    }

}