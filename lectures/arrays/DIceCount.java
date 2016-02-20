package lecture3;

import java.util.Random;

public class DIceCount {

	public static void count( int Trials) {
		int [] Count = new int[11];
		Random rand = new Random(54321);
		for( int i =0; i < Trials ;i++) {
			int d1 = rand.nextInt(6) + 1;
			int d2 = rand.nextInt(6) + 1;
			int roll = d1 + d2;
			int index = roll -2;
			Count[index]++;
		}
		printH(Count,Trials);
	}
	
	public static void header( int len) {
		for( int i =0; i < len;i++) {
			System.out.format( "%5d ", i + 2);
		}
		System.out.format( " %8s" , "Trials");
		System.out.format("\n");
	}
	
	public static void printH( int [] Count , int Trials) {
		for( int i =0; i < Count.length;i++) {
			double f = (double)Count[i]/Trials;
			System.out.format( "%5.3f ", f);
		}
		System.out.format( " %8d" , Trials);
		System.out.format("\n");
	}
	
	
	
	
	public static void main(String[] args) {
		int [] Trials = {100,500,1000,10000,900000};
		double [] V = {1,2,3,4,5,6,5,4,3,2,1};
		double sum=0;
		header(11);
		
		
		
		for ( int i =0; i < Trials.length ; i++)
			count(Trials[i]);
		for( int i = 0; i < V.length ;i++) sum += V[i];
		for( int i = 0; i < V.length ;i++) V[i]/=sum;
		for( int i = 0; i < V.length ;i++) 
			System.out.format("%5.3f ",V[i]);
		System.out.println();
	}

}
