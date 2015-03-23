
import java.io.*;

public class BinaryIO {

	public static void writeTextFile( String file, double [] data){
		try {
			PrintWriter out = new PrintWriter( file);
			for( double d : data) {
				out.format("%10.6f\n",d);
			}
			out.close();
		} catch ( IOException e) {
			System.out.println(e);
		}
	}
	
	public static void writeBinaryFile( String file , double [] data){
		try {
			DataOutputStream out = new DataOutputStream( new FileOutputStream(file));
			for( double d : data)
				out.writeDouble(d);
			out.close();
		} catch( IOException e) {
			System.out.println(e);
		}
	}
	public static void writeBinaryTest(){
		String file = "C:/users/jreynolds1/CMP-129/output/sample.dat";
		double [] data = new double[10];
		for( int i =0; i < data.length;i++) data[i]=i;
		writeBinaryFile(file,data);
		System.out.println("Write Binary Complete:" + file );
	}
	
	public static void writeTextTest(){
		String file = "C:/users/jreynolds1/CMP-129/output/sample.txt";
		double [] data = new double[10];
		for( int i =0; i < data.length;i++) data[i]=i;
		writeTextFile(file,data);
		System.out.println("Write Text Complete:" + file );
	}
	
	public static void main( String [] args ){
		//writeTextTest();
		writeBinaryTest();
		
		
	}
	
}
