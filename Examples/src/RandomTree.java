import java.util.Random;

class RandomTree {
    // Work in progress !

    private int       height_ ;
    private int [] [] tree_   ;

    RandomTree( int height ) {
	height_=height;
	buildTree();
    }

    void buildTree() {
	tree_ = new int[height_][];
	
    }

    int [] randomArray( int size ) {
	int [] A = new int[size];
	//Random rand = new Random();
	return A;
    }

}
