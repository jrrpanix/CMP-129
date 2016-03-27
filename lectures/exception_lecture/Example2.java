package lecture7;

import java.io.File;
import java.util.Scanner;

public class Example2 {

	public static void readData(String fileName ) throws java.io.FileNotFoundException{
		File f = new File(fileName);
		Scanner scan = new Scanner(f);
		while( scan.hasNextLine()) {
			String line = scan.nextLine();
		}
		scan.close();
	}
	
	public static void readButHandle( String fileName ) {
		try {
			File f = new File(fileName);
			Scanner scan = new Scanner(f);
			while( scan.hasNextLine()) {
				String line = scan.nextLine();
				double v = Double.parseDouble(line);
				System.out.println(v);
			}
			scan.close();
		} catch( java.io.FileNotFoundException e ) {
			
		}
		
	}
	
	public static void main( String [] args ) {
		readButHandle("SomeRandonName");
	}
	
}
