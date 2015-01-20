// Course      : CMP-129
// Title       : FileIOTest, enums , Exception class
// Instructor  : JReynolds

import java.io.PrintWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;


//-----------------------------------------------------------------
// private class that extends Exception for a bad action
//-----------------------------------------------------------------
class ActionException extends Exception {

    public ActionException() { super(); }
    public ActionException(String message) { super(message); }
    public ActionException(String message, Throwable cause) { super(message, cause); }
    public ActionException(Throwable cause) { super(cause); }
}

//-----------------------------------------------------------------
// private class to get command line arguments , demonstrates enum
//-----------------------------------------------------------------
class Args {


    enum Action { Create, Append , Read };

    Args( String [] args ) throws ActionException {
	file_ = new String();
	for( String s : args ) parse(s);
    }

    public void print() {
	System.out.println("file="+file_+",action="+action_.toString());
    }

    Action getAction() {
	return action_;
    }

    String getFile() {
	return file_;
    }

    private void parse( String arg ) throws ActionException {
	String [] sv = arg.split("=");
	if ( sv.length != 2 ) return;
	String key = sv[0];
	String value = sv[1];
	if ( isMatch( key, "--file" ))
	    file_ = value;
	if ( isMatch( key , "--action" ) )
	    setAction(value);
    }

    private void setAction( String value ) throws ActionException {
	String v = value.toLowerCase();
	if ( v.equals("read"))
	    action_=Action.Read;
	else if ( v.equals("append"))
	    action_=Action.Append;
	else if ( v.equals("create"))
	    action_=Action.Create;
	else {
	    throw new ActionException( "ActionException unknown action " + value );
	}
    }

    private boolean isMatch( String s , String expr ) {
	return s.equals( expr );
    }

    public String file_;
    public Action action_;
}


//-----------------------------------------------------------------
// Simple class which demonstrates creating a file, appending to and reading
//-----------------------------------------------------------------
public class FileIOTest {

    // 
    // Append
    public static void AppendToFile( String file , String [] X ) {
	try {
	    FileWriter fileWriter = new FileWriter(file,true);
	    PrintWriter writer = new PrintWriter(fileWriter);
	    for( String x : X )
		writer.println(x);
	    writer.close();
	}
	catch( java.io.FileNotFoundException e) {
	    System.out.println(e.toString());
	}
	catch( java.io.IOException e) {
	    System.out.println(e.toString());
	}

    }


    // Write
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
    
    // Read
    public static String [] ReadStringArray( String file ) {
	ArrayList<String> aList = new ArrayList<String>();
	File fileHandle = new File(file);
	if ( !fileHandle.exists() ) {
	    System.out.println("Going to throw an exception" );
	}
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
    

    //---------------------------------------------------------------
    // Test Modules 
    //---------------------------------------------------------------

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

    //---------------------------------------------------------------
    // main 
    //---------------------------------------------------------------
    public static void main( String [] args ) {
	// test run with args on windows machine
	// command line java FileIOTest --file=c:/users/john/workspace/Times/output/FirstFile.txt --action=create
	//
	try {
	    Args pargs = new Args(args);
	    pargs.print();
	    Args.Action action = pargs.getAction();
	    switch ( action ) {
	    case Read :
		System.out.println( "Read" );
		readTest(pargs.getFile());
		break;
	    case Create :
		System.out.println( "Create" );
		writeTest(pargs.getFile());
		break;
	    case Append :
		System.out.println( "Append" );
		String [] AppendStuff = {"Students","Are","Soooo","Excited","To","BE","HERE"};
		AppendToFile(pargs.getFile(),AppendStuff);
		break;
	    }
	}
	catch (ActionException e ) {
	    System.out.println( e.toString() );
	}
    }
}
