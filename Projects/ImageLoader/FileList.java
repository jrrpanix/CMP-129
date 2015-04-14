import java.io.*;
import java.util.*;


public class FileList {

    private ArrayList<String> files_;
    private String            dir_;
    

    public void load( String dir ) {
	dir_=dir;
	File f = new File(dir);
	files_ = new ArrayList<String>();
       	ArrayList<File> files = new ArrayList<File>(Arrays.asList(f.listFiles()));
	for( File fi : files ) {
	    files_.add(fi.getName());
	}
    }

    public ArrayList<String> getFiles() {
	return files_;
    }

    public String getDir() {
	return dir_;
    }

    public String toString() {
	String str = new String();
	for( String f : files_ ) {
	    str += f;
	    str += "\n";
	}
	return str;
    }

}