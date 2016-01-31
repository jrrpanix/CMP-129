package lecture1;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
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
	

	public static ArrayList<String> readFile( String fileName) {
		ArrayList<String> data = new ArrayList<String>();
		try {
			File f = new File(fileName);
			Scanner scan = new Scanner(f);
			while(scan.hasNextLine()) {
				data.add(scan.nextLine());
			}
			scan.close();
			
		} catch(Exception e) {
			e.printStackTrace(System.out);
		}
		return data;
	}
	
	public static void writeData( String fname , ArrayList<String> someData) {
		try {
			PrintWriter writer = new PrintWriter(fname);
			for(int i =0; i < someData.size(); i++) {
				writer.format("%s\n", someData.get(i));
			}
			writer.flush();
			writer.close();
			
		} catch(Exception e) {
			e.printStackTrace(System.out);
		}
		
	}
	
	public static void main(String [] args ) {
		FileIO.pwd();
		FileIO.listFiles(getwd());
		if ( args.length < 2) {
			System.err.println("expecting <input file name> <output file name>");
		} else {
			String inputFile = args[0];
			String outputFile = args[1];
			ArrayList<String> data = FileIO.readFile(inputFile);
			FileIO.writeData(outputFile,data);
		}
	}
	
}
