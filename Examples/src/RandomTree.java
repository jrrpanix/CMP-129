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

    static public void main( String [] args ) {
	RandomTree tree = new RandomTree(25);
	tree.print();
    }

}
