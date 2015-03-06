// Class      : CMP-129
// Assignment : Random Character String
// Due        : 1/26/2015
// Instructor : JReynolds

import java.util.Random;
import java.util.ArrayList;
import java.util.Iterator;

class RandomString {


    // (50 pts) We are going to create a random character string of parameter size where the possible range 
    // of characters is input to the funciton call from a [char start, char end].  
    // For example if we want to generate a character string where the characters are between 'A' and 'E', 
    // these would be the starting chacters.  We can usethe Random.nextInt() routine to help generate, by 
    // casting the char to int and then back to char.


    // -------------------------------------------------------------------------
    //
    // parameters 
    //    int len - the length of the string
    //    char First - the First Character in the Range 
    //    char Last  - the Last Character in the Range
    //
    //   Example CreateRandomString(5,'A','G') 
    //   will generate a random string of len 5, that will contain letters between 'A' and 'G'
    // 
    public static String CreateRandomString( int len , char First , char Last ) {
	int first = First > Last ? Last : First ;
	int last = First > Last ? First : Last;
	int range = last - first + 1;
	Random gen = new Random();
	char [] buffer = new char[len];
	for( int i = 0; i < len ; i++ )
	    buffer[i] = (char)( first + gen.nextInt(range) );
	return new String( buffer );
    }

    
    //--------------------------------------------------------------------------
    // Test Random String
    //--------------------------------------------------------------------------
    public static void TestRandomString() {
	ArrayList<String> stringList = new ArrayList<String>();
	int NumToGen = 20 , len = 6;
	char First = 'A' , Last = 'Z';
	for( int i = 0; i < NumToGen ; i++ ) {
	    stringList.add( CreateRandomString( len , First , Last ) );
	}

	for( Iterator<String> it = stringList.iterator() ; it.hasNext() ; ) {
	    System.out.println( it.next() );
	}
    }

    //--------------------------------------------------------------------------
    //
    //--------------------------------------------------------------------------
    public static void main( String [] args ) {
	TestRandomString();
    }

}
/*
  Sample output
VTIJJJ
YMGSOL
FLLVMI
AXTFFW
AEDCQF
UZHOOI
APIGVE
RAPPGT
BJCSXR
NNJYBG
GBMOEM
VOEPYH
GGKCQN
ANITLB
LJKPZI
YVHTUL
XDRHSF
WLJCXR
KOEMMD
PKJBQS
*/


