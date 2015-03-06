// Class      : CMP-129
// Assignment : Array Review Questions
// Due        : 1/26/2015
// Instructor : JReynolds

import java.util.Random;
import java.util.Arrays;
import java.lang.Math;

//------------------------------------------------------------------------------------------
// ArrayReview Questions and Answers
//------------------------------------------------------------------------------------------
class ArrayReview {

    //----------------------------------------------------------------------------------------------------------
    // (1) (5pts) Write the line of code to create an initalize an int array with {1,2,3,4}
    //----------------------------------------------------------------------------------------------------------
    public static void q1() {
	int [] A = {1,2,3,4};
    }

    //----------------------------------------------------------------------------------------------------------
    // (2) (5pts) Write the line of code to create an int array of size N, where N is an int.
    //----------------------------------------------------------------------------------------------------------
    public static void q2( int N ) {
	int [] A = new int[N];
    }

    //----------------------------------------------------------------------------------------------------------
    // (3) (5pts) Write a function to create an Array and sequentially fill it with int  from 1 to N . 
    //----------------------------------------------------------------------------------------------------------
    public static int[] createAndFillArray( int N ) {
	int [] A = new int[N];
	for( int i = 0; i < N ;i++ ) A[i] = i + 1;
	return A;
    }


    //----------------------------------------------------------------------------------------------------------
    //(4) (10 pts) Write a function to sum the contents of an int array.  
    //----------------------------------------------------------------------------------------------------------
    public static int sumArray( int [] A ) {
	int sum = 0;
	for( int a : A ) sum +=a;
	return sum;
    }


    // As a test case use and array of length 100, that was sequentially filled from 1 to 100 with the function you created in (1). 
    // Note the sum of integers from 1 to N is given by the formula N*(N+1)/2 so your answer should be 5050.
    public static void SumTestCase() {
	System.out.println("\nQuestion (4) Sum Array");
	System.out.println("----------------------");
	int N = 100;
	int [] A = createAndFillArray( N );
	int sum = sumArray(A);
	System.out.println("The sum of " + A[0] + " to " + A[A.length-1] + " = " + sum );
    }


    //----------------------------------------------------------------------------------------------------------
    // (5) (10 pts) Write a function to reverse the contents of a char array. 
    // For example if the original array is  char [] X = {'n' , 'o' , 'w' } then X reversed will be {'w','o','n'}.  
    // The prvoide test code to show it works.
    //----------------------------------------------------------------------------------------------------------
    public static char [] reverse( char [] X ) {
	int median = X.length / 2;
	for( int i = 0  , j = X.length - 1  ; i < median; i++,j-- ) {
	    char tmp = X[i];
	    X[i] = X[j];
	    X[j] = tmp;
	}
	return X;
    }

    public static void reverseTestCase ( char begin , char end  ) {
	int N = (int)end-(int)begin+1;
	if ( N <= 0 ) return;
	char []X  = new char[N];
	X[0]=begin;
	for( int i = 1 ; i < X.length ; i++ ) X[i]= (char)( (int)X[i-1] + 1 );
	System.out.println("before = " + new String(X) + " after = " + new String(reverse(X)) );
    }

    public static void TestReverse() {
	System.out.println( "\nQuestion (5) Algorithm to Reverse an Array");
	System.out.println( "------------------------------------------");
	reverseTestCase( '1' , '1' );
	reverseTestCase( '1' , '2' );
	reverseTestCase( '1' , '3' );
	reverseTestCase( 'A' , 'Z' );
	reverseTestCase( '1' , '9' );
    }



    //----------------------------------------------------------------------------------------------------------
    // (6) (10 pts) Write the code to create a Random Array of int of size 20 with number in the range 0 to 100  
    // and then use the Arrays.sort algorithm to sort it.   Print out the results of the array on a single line.
    // Size = Size of Aray , Range is from [0,Range) (e.g. includes 0 but upto Range -1 )
    //----------------------------------------------------------------------------------------------------------
    public static int [] createRandomIntArray( int Size , int Range ) {
	int [] A = new int[Size];
	Random rand = new Random();
	for( int i = 0; i < A.length ; i++ ) A[i]=rand.nextInt(Range);
	return A;
    }

    public static void print( int [] A ) {
	for( int a : A ) System.out.print(a + " " );
	System.out.println("");
    }


    public static void TestRandomArray() {
	// Note I will accept either 100 or 101 
	System.out.println("\nQuestion (6) Create Random Array & Sort it");
	System.out.println("------------------------------------------");
	int [] A = createRandomIntArray(20,101); 
	System.out.println( "Array Before Sort");
	print(A);
	System.out.println( "Array After Sort");
	Arrays.sort(A);
	print(A);
    }


    //----------------------------------------------------------------------------------------------------------
    // (7)(25 pts) A important part of computer science is understanding trade offs (speed vs simplicity) 
    // how long it takes things to complete and the types of data you have.  Randomly generate data sets of 
    // double size in multiples of 10 , where the double are in the range 0-9 starting at size 100 and stopping 
    // when the data set gets to 1 Million .  After generating the data, set the first array element to Math.PI 
    // (import java.lang.Math) and then run (import java.util.Arrasy) Arrays.sort() on sorted data set. After sorting 
    // the data set, do a binary search to find Math.PI and record keep track of how long it takes, the do a linear 
    // search to find Math.PI and record how long it takes (you may have to write your own linear search).
    // For each size multiple repeat 5 time and report the average time to sort and search.   
    //----------------------------------------------------------------------------------------------------------

    // Note this is not "static" because we need to create the "inner" class "StopWatch" this was
    // not part of the homework assignment to do this, this was done to keep all the code togehter
    public  void AlgoTimeTrials() {
	
	System.out.println( "\nQuestion (7) AlgoTimeTrials" );
	System.out.println( "---------------------------");
	int start = 100 , end = 1000000 , mult = 10;
	int NTrials = 5;
	double Range = 9.0;
	StopWatch watch = new StopWatch();
	double target = Math.PI;
	System.out.format( "%10s %12s %12s %12s\n" , "Size" , "AvgSort(us)" , "AvgBinary(us)" , "AvgLinear(us)" );
	System.out.format( "%10s %12s %12s %12s\n" , "----" , "-----------" , "-------------" , "-------------" );
	for( int Size = start ; Size <= end ; Size *= mult ) {
	    double [] sortTimes = new double[NTrials];
	    double [] binarySearchTimes = new double[NTrials];
	    double [] linearSearchTimes = new double[NTrials];
	    for( int i = 0; i < NTrials ; i++ ) {
		double [] A = createRandomDoubleArray(Size,Range);
		A[A.length-1] = target;
		sortTimes[i] = getSortTime( A , watch );
		binarySearchTimes[i] = getBinarySearchTime(A,target,watch);
		linearSearchTimes[i] = getLinearSearchTime(A,target,watch);
	    }
	    double avgSort = getAverage( sortTimes );
	    double avgBinary = getAverage( binarySearchTimes);
	    double avgLinear = getAverage( linearSearchTimes);
	    System.out.format( "%10d %12.1f %12.1f %12.1f\n" , Size , avgSort , avgBinary , avgLinear );
	}
    }

    public static double getAverage( double [] A ) {
	double sum = 0;
	for( double a : A ) sum += a;
	return sum / (double)A.length;
    }

    public static double getSortTime( double [] A , StopWatch watch ) {
	watch.start();
	Arrays.sort(A);
	watch.stop();
	return watch.timeus();
    }

    public static double getBinarySearchTime( double [] A , double target , StopWatch watch ) {
	watch.start();
	Arrays.binarySearch(A,target);
	watch.stop();
	return watch.timeus();
    }

    public static double getLinearSearchTime( double [] A , double target , StopWatch watch ) {
	watch.start();
	linearSearch(A,target);
	watch.stop();
	return watch.timeus();
    }

    public static double [] createRandomDoubleArray( int Size , double R ) {
	double [] A = new double[Size];
	Random rand = new Random();
	for( int i = 0; i < A.length ; i++ )A[i] = rand.nextDouble() * R;
	return A;
    }

    public static int linearSearch( double [] A , double target ) {
	for( int i = 0; i < A.length ; i++) if ( A[i] == target) return i;
	return -1;
    }

    //--------------------------------------------------------------
    // Stop Watch class needed for Time Trials
    //--------------------------------------------------------------
    class StopWatch {
	public long start_;
	public long stop_;
	StopWatch() {
	    start_=stop_=0;
	}
	
	void start() {
	    start_ = System.nanoTime();
	}
	
	void stop() {
	    stop_ = System.nanoTime();
	}
	
	double timeus() {
	    return (double)(stop_-start_)/1000.0;
	}
    }
    
    //----------------------------------------------------------------------------------
    // (8) (15 pts) Use an array to implement a Stack Class of int.  
    // A Stack is like a pile of dishes and contains the following methods, 
    // a check if the stack is empty, push to put something on the stack , 
    // pop to take something off the stack.  The constructor for 
    // stack should contain an int argument for the maximum depth the stack supports.
    //-----------------------------------------------------------------------------------


    //--------------------------------------------------------------
    // Stack Implementation
    //--------------------------------------------------------------
    class Stack {
	
	public Stack( int depth ) {
	    stack_ = new int[depth];
	    i_=0;
	}
	
	public boolean isEmpty() {
	    return i_ == 0;
	}
	
	public boolean isFull() {
	    return i_ == stack_.length;
	}
	
	public void push( int x ) {
	    if( isFull() ) {
		System.out.println( "Error Can\'t Push onto Stack, it's Full" );
		return;
	    }
	    stack_[i_++]=x;
	}
	
	public int pop() {
	    if( isEmpty() ) {
		System.out.println( "Error Can't Pop off Stack, it\'s Empty" );
		return -987654321;
	    }
	    return stack_[--i_];
	}
	
	private int [] stack_;
	private int    i_;
    }
    
    //--------------------------------------------------------------
    // Test the implementation of the Stack class
    // Notice this test method is not "static" because "Stack" is
    // an inner class and it can't be created from a "static" method!
    //--------------------------------------------------------------
    public void StackTest() {
	System.out.println( "\nQuestion (8) Stack Test" );
	System.out.println( "-----------------------");
	Stack s = new Stack(3);
	System.out.println( "push 0");
	s.push(0);
	System.out.println( "push 1");
	s.push(1);
	System.out.println( "push 2");
	s.push(2);
	System.out.println( "try to push 3");
	s.push(3); // error here pushing beyond stack depth, will print error messgae

	System.out.println( "pop " + s.pop() );
	System.out.println( "pop " + s.pop() );
	System.out.println( "pop " + s.pop() ); 
	System.out.println( "try to pop " ); // error here poping off empty stack
	s.pop();
    }

    //------------------------------------------------------------------------
    //(9) (20 pts) Write a brute force algorithm to do matrix multiplication of 2 Dimensional Arrays.
    //
    // Example Matrix Multiplication ..
    //  A      B           C
    // 1 2 *  5 6  =  1*5 + 2*7   1*6 + 2*8 
    // 3 4    7 8     3*5 + 4*7   3*6 + 4*8
    //
    //------------------------------------------------------------------------
    static public double[][] MatrixMult( double [][] A , double [][] B) {
	// A [NxK] *  B[KxZ]  = M[NxZ]
	if ( A.length == 0 || B.length == 0 || A[0].length != B.length ) {
	    System.out.println( "Matrix Mult Error, Invalid Input Matricies" );
	    return new double[1][1];
	}
	int Rows = A.length , Cols = B[0].length;
	double [][] M = new double[Rows][Cols];
	for( int i = 0; i < Rows ; i++ ) {
	    for( int j = 0; j < Cols ; j++ ) {
		M[i][j] = multRowByCol( A , B , i , j );
	    }
	}
	return M;
    }
    static public double multRowByCol( double [][] A, double [][] B ,int r , int c ) {
	int N = B.length;
	double sum = 0;
	for( int i = 0; i < N ;i++ ) sum += A[r][i] * B[i][c];
	return sum;
    }

    static public void print( double [][] A ) {
	for( int i = 0; i < A.length ; i++ ) {
	    for( int j = 0; j < A[i].length ; j++ ) {
		System.out.format( "%8.2f ",A[i][j]);
	    }
	    System.out.format( "\n");
	}
	System.out.format( "\n");
    }

    static public void MatrixMultTest() {
	System.out.println( "\nQuestion (9) Matrix Multiplication" );
	System.out.println( "----------------------------------");
	double [][] A = { {1,2,3}, {4,5,6} };
	double [][] B = { {7,8}, {9,10}, {11,12} };
	double [][] C = MatrixMult(A,B);
	System.out.println("Matrix A");
	print(A);
	System.out.println("Matrix B");
	print(B);
	System.out.println("Matrix C = A*B");
	print(C);


	double [][] A1 = { {1,0,0},{0,1,0},{0,0,1} };
	double [][] A2 = { {1,2,3},{4,5,6},{7,8,9} };
	double [][] A3 = MatrixMult(A1,A2);
	System.out.println("Matrix A3 = I * A2");
	print(A3);
    }


    //-------------------------------------------------------------
    // main 
    //-------------------------------------------------------------
    public static void main( String args[] ) {
	SumTestCase();
	TestReverse();
	TestRandomArray();
	new ArrayReview().AlgoTimeTrials();
	new ArrayReview().StackTest();
	MatrixMultTest();
    }



}

/*
  Output of Tests

Question (4) Sum Array
----------------------
The sum of 1 to 100 = 5050

Question (5) Algorithm to Reverse an Array
------------------------------------------
before = 1 after = 1
before = 12 after = 21
before = 123 after = 321
before = ABCDEFGHIJKLMNOPQRSTUVWXYZ after = ZYXWVUTSRQPONMLKJIHGFEDCBA
before = 123456789 after = 987654321

Question (6) Create Random Array & Sort it
------------------------------------------
Array Before Sort
53 32 77 59 40 100 89 56 3 62 47 70 39 85 57 26 100 88 25 2 
Array After Sort
2 3 25 26 32 39 40 47 53 56 57 59 62 70 77 85 88 89 100 100 

Question (7) AlgoTimeTrials
---------------------------
      Size  AvgSort(us) AvgBinary(us) AvgLinear(us)
      ----  ----------- ------------- -------------
       100        164.9         13.3          8.2
      1000       1270.8         10.8         24.2
     10000      19868.5         16.2        230.7
    100000      40164.3         14.9         95.7
   1000000     255999.5         22.2       1028.7

Question (8) Stack Test
-----------------------
push 0
push 1
push 2
try to push 3
Error Can't Push onto Stack, it's Full
pop 2
pop 1
pop 0
try to pop 
Error Can't Pop off Stack, it's Empty

Question (9) Matrix Multiplication
----------------------------------
Matrix A
    1.00     2.00     3.00 
    4.00     5.00     6.00 

Matrix B
    7.00     8.00 
    9.00    10.00 
   11.00    12.00 

Matrix C = A*B
   58.00    64.00 
  139.00   154.00 

Matrix A3 = I * A2
    1.00     2.00     3.00 
    4.00     5.00     6.00 
    7.00     8.00     9.00 

*/







