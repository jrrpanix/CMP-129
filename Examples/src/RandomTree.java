import java.util.Random;

class RandomTree {
    // Work in progress !

    private int       height_ ;
    private int [] [] tree_   ;

    public RandomTree( int height ) {
	height_=height;
	buildTree();
    }

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
	double secPath = 1e-6;
	double timeSec = p * secPath;
	double secPerYear = 365*24*60*60;
	return timeSec / secPerYear;
    }

    static public void main( String [] args ) {
	for ( int i = 1; i < 100 ; i++ ) {
	    RandomTree tree = new RandomTree(i);
	    //tree.print();
	    System.out.println( i + " " + "paths = " + tree.paths() + " years to calculate " + tree.yearsToCalculate());
	}
    }

}
