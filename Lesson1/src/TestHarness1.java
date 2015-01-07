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
	SearchResult(A,5,true);
	SearchResult(A,5,false);
	SearchResult(A,0,true);
	SearchResult(A,0,false);
	SearchResult(A,9,true);
	SearchResult(A,9,false);
	SearchResult(A,-100,true);
	SearchResult(A,-100,false);
	SearchResult(A,100,true);
	SearchResult(A,100,false);
    }

    public static void SearchResult( int [] A , int searchValue , boolean useBinary ) {
	int pos = useBinary ? Search1.binarySearch(A,searchValue) : Search1.linearSearch(A,searchValue);
	String algo = useBinary ? "BinarySearch" : "LinearSearch";
	String status = pos >= 0 ? "Found" : "NotFond";
	System.out.println("Algo="+algo + ",SearchValue=" + searchValue + ",Status=" + status + ",pos="  + pos);
    }

    //--------------------------------------------------------
    // Timing Tests
    //--------------------------------------------------------
    public static void TimerTests() {
	StopWatch1 watch = new StopWatch1();
	watch.start();
	int Big = 10000 , Range=10000;
	int [] A = Random1.RandomIntArray(Big,Range);
	watch.stop();
	System.out.println( "Time to create RandomIntArray of Size= " + A.length + "=" + watch.timeus() + " us" );

	watch.start();
	Sort1.selectionSort(A);
	watch.stop();
	System.out.println( "Time to sort RandomIntArray of Size= " + A.length + "=" + watch.timeus() + " us" );

	watch.start();
	A = Random1.SequentialIntArray(Big,0,1);
	watch.stop();
	System.out.println( "Time to create SequentialIntArray of Size= " + A.length + "=" + watch.timeus() + " us" );
	watch.start();
	Sort1.selectionSort(A);
	watch.stop();
	System.out.println( "Time to sort SequentialIntArray of Size= " + A.length + "=" + watch.timeus() + " us" );   
    }


    //--------------------------------------------------------
    // main
    public static void main( String[] args ) {
	TestAsString(); 
	TestRandom();
	TestSort();
	TestSearch();
	TimerTests();
   }
    
}