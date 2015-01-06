import java.util.Random;
import java.util.Scanner;
public class ArrayExamples {

    public int smallestIndex( int [] A , int pos) {
	int m = pos;
	for( int i = pos + 1 ; i < A.length ; i++ )
	    if ( A[i] < A[m]) m = i;
	return m;
    }
    
    public void swap( int [] A , int i , int j ) {
	int tmp = A[i];
	A[i]=A[j];
	A[j]=tmp;
    }
    
    
    public void selectionSort( int [] A) {
	for( int i = 0; i < A.length - 1 ; i++) {
	    swap( A , i , smallestIndex(A,i));
	}
    }
    
    public int binarySearch( int [] A , int value ) {
	int b = 0 , e = A.length;
	while( true ) {
	    int i = (e + b) /2;
	    if ( A[i] == value ) return i;
	    if ( A[i] < value ) b = i;
	    else e=i;
	    if ( e == b) break;
	}
	return -1;
    }
    
    public int findIndexOf( int [] A , int value , int pos ) {
	for( int i =pos; i < A.length ; i++)
	    if ( A[i] == value ) return i;
	return -1;
    }
    
    public void printArray( int [] A ) {
	for ( int a : A ) 
	    System.out.print(a + " ");
	System.out.println("");
    }
    
    public void reportStats( int size , int min , int max, double mean) {
	System.out.println("size = " + size +",min=" + min + ",max=" + max + ",mean=" + mean);
    }
    
    public double calcMean( int[] A){
	double sum = 0;
	for( int a :A ) sum += a;
	return sum/A.length;
    }
    
    public int getMax( int [] A) {
	int max = Integer.MIN_VALUE;
	for( int a : A ) if (a > max  ) max = a;
	return max;
    }
    
    public int getMin( int [] A) {
	int min = Integer.MAX_VALUE;
	for( int a : A ) if (a < min  ) min = a;
	return min;
    }
    
    
    public void fillRandom( int[] A , int Range ){
	Random gen = new Random();
	for(int i = 0; i < A.length ; i++)
	    A[i] = gen.nextInt(Range);
    }
    
    public int [] createRandomArray( int Size , int Range) {
	int [] A = new int[Size];
	fillRandom( A, Range );
	return A;
    }
    
    public void randomSample( int Size , int Range) {
	int [] A = createRandomArray( Size , Range);
	reportStats(A.length,getMin(A),getMax(A),calcMean(A));
    }
    
    public void randomNumberExample() {
	final int Range = 100; // make it a constant
	int [] simulator = {10,100,1000,10000,500000,1000000,5000000,10000000};
	for( int s : simulator)
	    randomSample(s,Range);
    }
    
    public int [] arrayCopy( int [] A) {
	int [] B = new int[A.length];
	for( int i = 0; i < A.length ; i++) B[i]=A[i];
	return B;
    }
    
    public void deepCopyExample() {
	int [] A = {0,1,2};
	int [] B = A.clone();
	B[2]=-987;
	printArray(A);
	printArray(B);
	int [] C = arrayCopy(B);
	printArray(C);
	int [] D = new int[C.length-1];
	System.arraycopy(C, 1, D, 0, D.length);
	printArray(D);
	D[0]=8888;
	printArray(C);
	printArray(D);
    }
    
    public void  shallowCopyExample() {
	int [] A = {0,1,2,3,4,5,6};
	int [] B = A;
	printArray(A);
	printArray(B);
	B[3]=-9876;
	printArray(A);
	System.out.println( "index of -9876=" + findIndexOf(B,-9876,0));
    }
    
    public void inputExample() {
	Scanner keyboard = new Scanner(System.in);
	final int Entries = 5;
	String [] S = new String[5];
	for ( int i = 0; i < Entries ; i++) {
	    System.out.print( "Enter a string:");
	    S[i]=keyboard.next();
	}
	for(String s : S ) System.out.println( s);
	keyboard.close();
    }
    
    public void sortExample() {
	int [] A = createRandomArray( 34 , 100);
	printArray(A);
	selectionSort(A);
	printArray(A);
	for( int i = 0 ; i < A.length; i++ ) {
	    int ix = binarySearch(A,A[i]);
	    System.out.println("index of serach =" + ix + " index=" + i);
	}
	
	int ix = binarySearch(A,-90999);
	System.out.println("index of serach =" + ix);
    }
    
    
    public void firstExample() {
	// Create an Array
	int [] A = {0,1,2,3,4,5};
	printArray(A);
	A[0]++;
	System.out.println("A[0]=" + A[0]);
	++A[0];
	System.out.println("A[0]=" + A[0]);
	
    }
    
    
    
    public void dim2() {
	int [] [] A = { {1,2,3,4},{5,6,7,8},{9,10,11,12} };
	int rows = A.length;
	int cols = A[0].length;
	for( int i = 0; i < rows ; i++) {
	    for( int j = 0; j < cols ; j++) System.out.print( A[i][j] + " ") ;
	    System.out.println(" ");
	}
	
    }
    
    public void example1() {
	
	//firstExample();
	//shallowCopyExample();
	//deepCopyExample();
	//inputExample();
	//dim2();
	sortExample();
	//randomNumberExample();
    }
    
    public static void main(String[] args) {
	// TODO Auto-generated method stub
	ArrayExamples e = new ArrayExamples();
	e.example1();
    }

}
