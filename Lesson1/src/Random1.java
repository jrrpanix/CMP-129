import java.util.Random;


class Random1 {

    // Create a Random Array of Integers
    public static int [] createInt( int Size , int Range ) {
	if ( Size <= 0 ) return new int[0];
	int [] A = new int[Size];
	Random gen = new Random();
	for(int i = 0; i < A.length ; i++)
	    A[i] = gen.nextInt(Range);
	return A;
    }

}
