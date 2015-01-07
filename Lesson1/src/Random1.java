// Course      : CMP-129
// Chapter     : Lesson1 
// Title       : Random Number Generator     
// Instructor  : JReynolds

// Course      : CMP-129
// Chapter     : Lesson1 
// Title       : Generate Arrays of Random numbers
// Instructor  : JReynolds


import java.util.Random;

class Random1 {

    //
    // Create a Array of Random Integers 
    // Inputs:
    //    int Size - the number of element in the array
    //    int Range - randome number range [0 , Range-1]
    // Output :
    //    int [] - Randomly generated int Array of length=Size
    //
    public static int [] RandomIntArray( int Size , int Range ) {
	if ( Size <= 0 ) return new int[0];
	int [] A = new int[Size];
	Random gen = new Random();
	for(int i = 0; i < A.length ; i++)
	    A[i] = gen.nextInt(Range);
	return A;
    }

    //
    // Create a Array of Sequential Integers (NonRandom)
    public static int [] SequentialIntArray( int Size , int Start , int Step ) {
	if ( Size <= 0 ) return new int[0];
	int [] A = new int[Size];
	for(int i = 0,v=Start; i < A.length ; i++,v+=Step )
	    A[i] = v;
	return A;
    }

}
