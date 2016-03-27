package lecture7;

// Gaddis Chapter 11 Stuff on Exceptions 

public class Example1 {
	
	public static void test1() {
		try {
			int [] X = new int[4];
			X[4]=1000;
			System.out.format("%d",1.111);
		}catch( java.util.IllegalFormatConversionException e) {
			System.out.println("catching illegal format but running");
		} catch( java.lang.ArrayIndexOutOfBoundsException e) {
			System.out.println("catching array out of bounds");
		} catch( Exception e) {
			System.out.println("catching generic excception");
			e.printStackTrace(System.out);
		}
	}
	
	public static void test2() {
		System.out.println("we are still runiing");
	}
	
	
	
	public static void main( String [] args ) {
		test1();
		test2();
		
	}
}
