// Course      : CMP-129
// Title       : Job Interview Question : Optional homework
// Instructor  : JReynolds

import java.util.Random;
import java.util.Arrays;

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

    // Question 1 : Create Tree code is in buildTree
    // Question 2 : Getting maximum sum code is in solve
    //              Tree is solved by starting from the end nodes and
    //              walking up to node 0
    //
    // Example        1
    //             33   22
    //
    // for this tree since there is only 2 nodes , 33 > 22 so we pick 33
    // now the only node left is one so the max sum = 34 == 33 + 1
    //
    // Example        4
    //              6    22
    //          100   21    33
    // 
    // if we start at the second to last if we are at node "6" then
    // the best way to go is "100" and if ew are at node "22" the
    // best way to go is "33" so our tree will look like this
    //
    //
    //                4
    //          100+6    22+33
    //
    // 
    // now for this the 100+6 is better than 22+33
    //
    // so our max sum is 100+6+4
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

    public double solve() {
	int[][] cp = copyTree();
	for( int i = height_ - 2 ; i >=0 ;i-- ) {
	    int rn = i + 1;
	    for ( int j = 0; j < cp[i].length ; j++ ) {
		int a1 = cp[rn][j];
		int a2 = cp[rn][j+1];
		if ( a1 > a2 ) cp[i][j] += a1;
		else  cp[i][j] += a2;
	    }
	}
	int sum = cp[0][0];
	return sum;
    }

    public int [][] copyTree() {
	int [][] cp = new int[height_][];
	for( int i = 0; i < height_ ;i++ ) {
	    cp[i] = Arrays.copyOf( tree_[i], tree_[i].length );
	}
	return cp;
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
	System.out.println( "max sum = " + tr.solve() );
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
	if ( args.length > 0 ) {
	    WalkTest(Integer.valueOf(args[0]));
	}
	else
	    CalcTimeTest();
    }

}
