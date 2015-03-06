// Class      : CMP-129
// Assignment : Lecture4 Class Assignment 2
// Due        : 1/26/2015
// Instructor : JReynolds

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Lecture4Assignment2 { // this was called ReadFile in lecture 4

/*

The purpose of this exercise is to check your skills in opening and reading files.  
A big part of software development is getting data (either from files, databases, 
user input, the web or other types of servers).  For this exercise your ability to 
read data from existing files will be checked.  If you review the code samples in GitHub 
or read Chapter 4 of your text you will have enough information to do this exercise.

   import statements (java.io.File,java.io.FileNotFoundException,java.util.Scanner)
   the File class
   the Scanner class
   putting a try/catch around Scanner when you create it
   ome member functions of Scanner (hasNext(), hasNextLine(),next(),nextLine())
 

Task1 (10 points) Create a Java Class in project Lecture4 named ReadFile

Task2 (40 points) Create a static function called countWords and write the code for 
                  which returns the number of words scanned (determined by next()) 
                  and takes as an argument the file name.  The code will open the file and 
                  scan through the file keeping track of the number of words it reads.

                  public static long countWords( String fileName )

Task3 (40 points) After you write the function "countWords" in the Java file ReadFile , you 
                  will need to test that it works.  Using any text editor (or Microsoft word) 
                  create a file called TestFileA2.txt and put in the file the following line :

                            This file has five words.

                   Then in the "ReadFile.java" class  add a public static void main( String args[] ) 
                   and call your function countWords , use args[0] to input the name and location of TestFileA2.txt 
                   that you created and print out the number of words in the file.

                   Once this test is sucessful (it should have counted five words) you will then run your 
                   program on the SOU.txt file found in GitHub and report the number of words in that file.  
                   It should be several thousand words.
*/



    public static long countWords( String fileName ) {
	long count = 0;
	File fileHandle = new File( fileName );
	if ( !fileHandle.exists() ) {
	    System.out.println( "Input file " + fileName + " does not exist" );
	    return count;
	}
	try {
	    Scanner scan = new Scanner( fileHandle );
	    while( scan.hasNext() ) {
		scan.next();
		count++;
	    }
	}
	catch( FileNotFoundException ex ) {
	    System.out.println( "Caught Exception in countWords " + ex.toString() );
	}
	return count;
    }


    public static void main( String [] args ) {
	if ( args.length ==0 ) {
	    System.out.println( "main requires one argument <filename>" );
	    return;
	}
	String fileName = args[0];
	long numWords = countWords(fileName);
	System.out.println( "The number of words in file " + fileName + " is " + numWords );
    }
}

/*
Test Output

run 1  : java Lecture4Assignment2 ./TestFileA2.txt 
output : The number of words in file ./TestFileA2.txt is 5

run 2  : java Lecture4Assignment2 ../Examples/src/SOU.txt 
output : The number of words in file ../Examples/src/SOU.txt is 6495

*/

