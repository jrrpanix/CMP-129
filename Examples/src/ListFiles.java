// course      : CMP-129
// instructor  : JReynolds
// description : Listing files in a directory  
// 


import java.io.*;
import java.util.*;

public class ListFiles {

    public static String getCurrentDir() {
	try {
	    File f = new File(".");
	    return f.getCanonicalPath();
	} catch( IOException e ) {
	    System.out.println(e);
	}
	return new String();
	
    }

    public static ArrayList<String> getFiles( String dir , boolean justFile ) {
	ArrayList<String> fileNames = new ArrayList<String>();
	File f = new File(dir);
	ArrayList<File> files = new ArrayList<File>(Arrays.asList(f.listFiles()));
	for( File item : files )
	    if ( justFile )
		fileNames.add(item.getName());
	    else
		fileNames.add(item.getPath());
	return fileNames;
    }

    public static void main( String [] args ) {
	String currDir = getCurrentDir();
	System.out.println( currDir);
	boolean justFile = args.length > 0 ? true : false;
	ArrayList<String> names = getFiles( currDir , justFile );
	for( String name : names ) {
	    System.out.println(name);
	}
    }
}
