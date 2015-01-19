import java.io.PrintWriter;
import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;

public class FileIOTest {

    public static void WriteStringArray( String file , String [] X) {
	try {
	    PrintWriter writer = new PrintWriter(file);
	    for( String x : X )
		writer.println(x);
	    writer.close();
	}
	catch( java.io.FileNotFoundException e) {
	    System.out.println(e.toString());
	}
    }
    
    public static String [] ReadStringArray( String file ) {
	ArrayList<String> aList = new ArrayList<String>();
	File fileHandle = new File(file);
	try {
	    Scanner scan = new Scanner(fileHandle);
	    while( scan.hasNextLine()) {
		aList.add( scan.nextLine());
	    }
	    scan.close();
	}
	catch ( java.io.FileNotFoundException e) {
	    System.out.println(e.toString());
	}
	String [] sArray = new String[aList.size()];
	aList.toArray(sArray);
	return sArray;
    }
    
    public static void writeTest( String file ) {
	String [] Names = {"Tracy","John","Alex","James"};
	System.out.println( "Running writeTest with file " + file);
	WriteStringArray( file , Names);
    }
    
    public static void readTest( String file ) {
	System.out.println( "Running readTest with file " + file );
	String [] sArray = ReadStringArray( file );
	for ( String s : sArray) 
	    System.out.println(s);
    }
    
    public static void main( String [] args ) {
	// test run with args on windows machine
	// "c:/users/john/workspace/Times/output/FirstFile.txt"
	if ( args.length < 1) {
	    System.out.println("unable to run test need a file name as arg");
	    return;
	}
	String fileName = args[0];
	writeTest(fileName);
	readTest(fileName);
    }
    
}
