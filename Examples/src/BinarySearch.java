// Course      : CMP-129
// Title       : Binary Search
// Instructor  : JReynolds

public class BinarySearch {

    // Implemnetation of binarySearch Algorithm
    // Note : This algorithm requires that A be sorted!!!
    // Inputs: 
    // int [] A   : A sorted Array
    // int value  : the value we are searching for
    // Returns :
    //     if i >=0  : this is the position of 'value'
    //     if i ==-1 : then 'value' not found
    //
    // Algorithm 
    //  Search range starts from [b=0,e=length-1] (b,begin) (e,end)
    //  get the mid point i of b and e 
    //  if A[i] == value return i

    //  else if the A[i] is less than value then we know
    //  the value is above index i so serach is now from b=i+1 to e
    //  
    //  else the value is in the bottom half so we ajdust e to i-1 
    // 
    public static int binarySearch( int [] A , int value ) {
	int b = 0 , e = A.length-1;
	while ( b <= e ) {
	    int i = (e + b) /2;
	    if ( A[i] == value ) return i;
	    if ( A[i] < value ) b = i+1;
	    else e = i -1 ;
	}
	return -1;
    }


    // search through array starting from 0 until value found
    public static int linearSearch( int [] A , int value ) {
	for( int i = 0; i < A.length ; i++ )
	    if ( A[i] == value ) return i;
	return -1;
    }

}