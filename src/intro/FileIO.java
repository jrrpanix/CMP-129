package intro;

import java.io.File;
import java.util.Scanner;
import java.nio.file.Paths;
import java.nio.file.Path;

public class FileIO {
	
	
	public static void pwd() {
		Path p = Paths.get(".");
		System.out.println("root " + p.toAbsolutePath().getRoot());
		System.out.println("abs path " + p.toAbsolutePath());
		System.out.println("file name " + p.toAbsolutePath().getFileName());
		System.out.println("parent " + p.toAbsolutePath().getParent());
	}
	
	public static String getwd() {
		Path p = Paths.get(".");
		return p.toAbsolutePath().getParent().toString();
	}
	
	public static void listFiles( String dir) {
		try {
			File fptr = new File(dir);
			File [] flist = fptr.listFiles();
			for (File f : flist ){
				boolean isfile = f.isFile();
				boolean isdir = f.isDirectory();
				System.out.println(f.getAbsolutePath() + " isfile=" + isfile + " isdir=" + isdir);
				if (isdir) {
					listFiles(f.getAbsolutePath());
				}
			}
			
		} catch(Exception e) {
			e.printStackTrace(System.out);
		}
	}
	

	public static void printFile( String fileName) {
		try {
			File f = new File(fileName);
			Scanner scan = new Scanner(f);
			while(scan.hasNextLine()) {
				System.out.println(scan.nextLine());
			}
			scan.close();
			
		} catch(Exception e) {
			e.printStackTrace(System.out);
		}
	}
	
	public static void main(String [] args ) {
		pwd();
		listFiles(getwd());
		printFile(args[0]);
	}
	
}
