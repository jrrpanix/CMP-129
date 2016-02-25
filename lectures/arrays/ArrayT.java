package lecture3;

import java.util.Random;

public class ArrayT {

	public static void examples() {
		int [] A = { 1 , 2, 3, 4 ,5 };
		System.out.println(A[2]);

		int SizeB = 100000;
		int [] B = new int[SizeB];
		Random rand = new Random(54321);
		int bound = 11;
		for( int i =0; i < B.length ; i++) {
			B[i]=rand.nextInt(bound);
		}
		
		long sum =0;
		for( int i =0; i < B.length ;i++) {
			sum += B[i];
		}
		
		System.out.format( "sum = %10d\n",sum);
		
		int [] Count = new int[bound];
		System.out.println(Count[0]);
		for( int i =0; i < B.length ;i++) {
			int ix = B[i];
			Count[ix]++;
		}
		
		// verticle output 
		for( int i =0; i < Count.length ; i++) {
			//double f = (double)Count[i]/B.length;
			//System.out.format( "%5d %5d %6.4f\n",i,Count[i],f);
		}
		
		// horizontal output 
		for( int i =0; i < Count.length ;i++) {
			System.out.format( "%6d ",i);
		}
		System.out.format("\n");
		for( int i =0; i < Count.length ;i++) {
			double f = (double)Count[i]/B.length;
			System.out.format( "%6.4f ",f);
		}
		System.out.format("\n");
		
		
		
	}
	
	
	public static void main(String[] args) {
		System.out.println("Starting ArrayTest");
		examples();
	}

}
