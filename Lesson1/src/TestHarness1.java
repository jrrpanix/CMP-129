// Course      : CMP-129
// Chapter     : Lesson1 
// Title       : Test Harness
// Instructor  : JReynolds



public class TestHarness1 {
    // TestHarness of Code going from visual inspection to more robust testing methods

    // Create a space delimited String from elementin in Array
    public static String AsString( int [] A ) {
	String s = new String();
	for( int a : A ) {s += a; s += " "; }
	return s;
    }


    //--------------------------------------------------------------
    // Test the various implementations in this section
    // Note these tests are not robust and only visual
    // Better testing does not rely on visual inspection!

    // 0
    // Test AsString
    public static void TestAsString() {
	String TestName = "Test AsString";
	int [] A = { 1 , 2, 3 };
	System.out.println(TestName);
	System.out.println(AsString(A));
    }

    // 1
    // Test Random
    public static void TestRandom() {
	String TestName = "Test Random";
	int [] A = Random1.RandomIntArray( 15 , 1000 );
	System.out.println(TestName);
	System.out.println(AsString(A));
    }


    // 2
    // Test Sort
    public static void TestSort() {
	String TestName = "Test Sort";
	int [] A = Random1.RandomIntArray( 15 , 1000 );
	System.out.println(TestName);
	Sort1.selectionSort(A);
	System.out.println(AsString(A));
    }


    // 3
    // Test Search
    public static void TestSearch() {
	String TestName = "Test Search";
	System.out.println(TestName);
	// Create an Array of Size 10 and fill with 0 to 9
	int [] A = Random1.SequentialIntArray( 10 , 0 , 1 );
	System.out.println(AsString(A));
	int p,v;
	v = 5;
	p = Search1.binarySearch(A,v);
	System.out.println("Searching for " + v + " found at pos=" + p + " value=" + A[p]);
    }

    //--------------------------------------------------------
    // main
    public static void main( String[] args ) {
	TestAsString(); 
	TestRandom();
	TestSort();
	TestSearch();
   }
    
}