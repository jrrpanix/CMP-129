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
    // Generate a Random String
    // len = String Length
    // Random Character Range starts at First and ends at Last
    // For example First='A',Last='Z'
    public static String RandomString( int len , char First , char Last ) {
	int first = First > Last ? Last : First ;
	int last = First > Last ? First : Last;
	int range = last - first + 1;
	Random gen = new Random();
	char [] buffer = new char[len];
	for( int i = 0; i < len ; i++ )
	    buffer[i] = (char)( first + gen.nextInt(range) );
	return new String( buffer );
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

    public static void main( String [] args ) {
	for( int i = 0; i < 10 ; i++ )
	    System.out.println( RandomString( 6, 'A' , 'E' ) );
    }

}
