package lecture7;

import java.io.File;
import java.util.Scanner;

public class Example3 { 
	
	public static void read( String fileName, int ix ) throws BadCsvFileException {
		try {
			File f = new File(fileName);
			Scanner scan = new Scanner(f);
			double sum=0;
			try {
				boolean isheader = true;
				while( scan.hasNextLine()) {
					String line = scan.nextLine();
					if ( isheader) {
						isheader=false;
						continue;
					}
					String [] sv = line.split(",");
					sum += Double.parseDouble(sv[ix]);
				}
			}
			catch( NumberFormatException e ) {
				throw new BadCsvFileException("file" + fileName);
			}
			//catch( Exception e) {
			//	System.out.println("catching generic exception " + e.getMessage());
			//}
			finally {
				scan.close();
				System.out.println("finally block executing sum=" + sum);
			}
		} catch( java.io.FileNotFoundException e ) {
			e.printStackTrace(System.err);
		}
	}
	
	public static void callRead( String fname , int ix ) {
		try{
			read(fname,ix);
		}catch (BadCsvFileException e) {
			
		}
	}
	
	public static void main( String [] args ) {
		String fname = "C://Users/jreynolds1/git/CMP-129/data/google_prices.csv";
		callRead(fname,0);
	}
	
	
}
