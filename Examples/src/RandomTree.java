// Course      : CMP-129
// Title       : Random Tree 
// Instructor  : JReynolds

import java.util.Random;

class RandomTree {
    //
    // This represents an expoential growth problem
    // For every additional unit the height in the tree, it doubles
    // the number of possible paths in the tree
    // The number of possible paths in the tree is equal to 
    // pow(2,height-1)
    //
    // so at at height of 46 there are 3.51E13 ( > 35 Trillion paths)
    // which would take over a year to calculate all possible paths
    // if we assume 1 microsecond per path!
    //

    //--------------------------------------------------------
    // public interface 
    //--------------------------------------------------------
    public RandomTree( int height ) {
	height_=height;
	buildTree();
    }

    public void print() {
	for( int i = 0; i < tree_.length ; i++  ) {
	    for( int j = 0 ; j < tree_[i].length ; j++ )
		System.out.print( tree_[i][j] + " " );
	    System.out.println("");
	}
    }

    public double paths() {
	return Math.pow( 2, height_ - 1 );
    }

    public double yearsToCalculate() {
	double p = paths();
	double secPath = 1e-6; // Assume it takes 1 microsecond per tree path
	double timeSec = p * secPath;
	double secPerYear = 365*24*60*60;
	return timeSec / secPerYear;
    }

    public void walkTree() {
	final int maxPaths = 2048;
	if ( paths() > maxPaths ) {
	    System.out.println( "Not walking tree , number of paths > " + maxPaths );
	    return;
	}
	int [] visit = new int[height_];
	path_=0;
	walk_( 1 , 0 , visit);
	
    }


    //-------------------------------------------------------
    // methods to build the tree
    //-------------------------------------------------------
    private void buildTree() {
	tree_ = new int[height_][];
	for( int i = 0; i < height_ ;i++ )
	    tree_[i] = randomArray(i+1);
    }

    private int [] randomArray( int size ) {
	int [] A = new int[size];
	Random rand = new Random();
	for( int i = 0; i < size ; i++ )
	    A[i]=rand.nextInt(99);
	return A;
    }


    //-------------------------------------------------------
    // Walk the tree from top to bottom
    //-------------------------------------------------------
    private void walk_( int h , int n , int [] path ) {
	int node = tree_[h-1][n];
	path[h-1]=node;
	if ( h == height_ ) {
	    path_++;
	    System.out.print( "Path:" + path_ + ":");
	    int sum = 0;
	    for( int i = 0; i < path.length ; i++ ) {
		System.out.print(path[i]);
		if ( i != path.length-1)
		    System.out.print( "->");
		sum += path[i];
	    }
	    System.out.println(":sum="+sum);
	}
	else {
	    walk_(h+1,n,path);
	    walk_(h+1,n+1,path);
	}
    }

    //---------------------------------------------
    // private implementation variables 
    //---------------------------------------------
    private int      height_ ;
    private int [][] tree_   ;

    private int      path_   ;


    //-------------------------------------------------
    // Test Modules
    //-------------------------------------------------
    static public void WalkTest( int height ) {
	RandomTree tr = new RandomTree(height);
	tr.print();
	tr.walkTree();
    }

    static public void CalcTimeTest() {
	// Calcaluate the number of paths through the tree and the total computation time
	// as the tree grows from 1 to 99
	for ( int i = 1; i <= 100 ; i+=4 ) {
	    RandomTree tree = new RandomTree(i);
	    System.out.println( i + " " + "paths = " + tree.paths() + " years to calculate " + tree.yearsToCalculate());
	}
    }

    static public void main( String [] args ) {
	if ( args.length > 0 )
	    WalkTest(Integer.valueOf(args[0]));
	else
	    CalcTimeTest();
    }

}
