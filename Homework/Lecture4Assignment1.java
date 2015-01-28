import java.util.Arrays;

class Lecture4Assignment1 {   // Note we called this class MyName in the Lecture 

/*
Assignment Tasks
------------------
Task 1 (10 points) Start up the Java IDE, Eclipse
Task 2 (10 points) Create a Java Project and name it .Lecture4.

Task 3 (10 points) Create a Java Class under Project Lecture4 and name it MyName
                   When creating the check the appropriate box to create a .static void main..
Task 4 (10 points) Once this class is created add code to main to print your name using the statement:

                    Hello, my name is [YOUR NAME HERE]

Task 5 (10 points) Under Run/Run Configurations 
                   Add the following to (x)=Arguments (aka adding Command line arguments)

    this is some sample input

Task 6 (10 points)  Create a static void function called printArgs that takes a String [] 
                    as a function argument and prints the contents of the array, 
                    with each element of the array printed on a separate line.

Task 7 (10 points) Call the function printArgs from main passing the parameter args to printArgs.  
                   This function call in main will be below(after) the line where you printed your name.

Task 8 (10 points) Using java.util.Arrays , add code to main that sorts the 
                   args array and then calls the function printArgs  
                   which was created in task 7.
*/


    static public void printArgs( String [] args ) {
	for( String s : args ) System.out.println(s);
    }


    static public void main( String [] args ) {
	System.out.println( "Hello, my name is John" );
	printArgs(args);
	Arrays.sort(args);
	printArgs(args);
    }
    
}

/*
Program output if the command line is:  this is some sample input

Hello, my name is John
this
is
some
sample
input
input
is
sample
some
this
*/


