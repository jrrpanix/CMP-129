package lecture3;

import java.util.ArrayList;

public class ArrayListTest {
	
	static public void example1() {
		
		ArrayList<Integer> A = new ArrayList<Integer>();
		for( int i =0; i < 5; i++) {
			A.add(i);
		}
		print(A);
		A.remove(0);
		print(A);
		A.remove(new Integer(3));
		print(A);
		A.add(2, -11);
		print(A);
		
	}
	
	static public void print( ArrayList<Integer> A) {
		System.out.print("size = " + A.size() + ":");
		for( int a : A) {
			System.out.print(a + " " );
		}
		System.out.println();
	} 
	

	public static void main(String[] args) {
		example1();

	}

}
