package Bytes;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class ByteExample {
	
	public static byte [] getBytes( int v, ByteOrder order) {
		final int N = Integer.BYTES;
		byte [] byteArray = new byte[N];
		ByteBuffer bb = ByteBuffer.wrap(byteArray);
		bb.putInt(v);
		return byteArray;
	}
	
	public static int getInt( byte [] byteArray ) {
		ByteBuffer bb = ByteBuffer.wrap(byteArray);
		return bb.getInt();
	}
	
	public static String getBytesAsString( byte [] ba) {
		String s = new String();
		for ( byte b : ba ) {s += " " ; s += Integer.toString(b);}
		return s;
	}
	
	public static void printPattern( byte ...bytes) {
		String byteString = getBytesAsString(bytes);
		int value = getInt(bytes);
		System.out.format( "%16s %11d\n",byteString,value);
	}
	
	public static void patterns() {
		printPattern( (byte)127,(byte)127,(byte)127,(byte)127);
		printPattern( (byte)127,(byte)-1,(byte)-1,(byte)-1);
		
	}
	
	public static void expPat() {
		for( int i =1 ; i < 33 ; i++) {
			long lv = (long)Math.pow(2, i);
			int x =(int)lv;
			byte [] ba = getBytes(x,ByteOrder.BIG_ENDIAN);
			System.out.format( "%d %d %d %s\n",i,lv , x,getBytesAsString(ba));
		}
	}
	
	public static void hex() {
		int [] V = { 15 , 127 , -127 , 128 , 255, Integer.MAX_VALUE , Integer.MIN_VALUE};
		for( int v : V) {
			String binary = Integer.toBinaryString(v);
			String hex = Integer.toHexString(v);
			byte [] bytes = getBytes(v,ByteOrder.BIG_ENDIAN);
			String byteStr = getBytesAsString(bytes);
			int bval = getInt(bytes);
			byte last = bytes[bytes.length-1];
			bytes[bytes.length-1]=0;
			int lowerZero = getInt(bytes);
			bytes[bytes.length-1]=last;
			bytes[0]=0;
			int upperZero=getInt(bytes);
			System.out.format( "%11d %33s %9s %14s %11d %11d %11d\n",
					v , binary, hex,byteStr,bval,lowerZero,upperZero);
		}
	}

	public static void main(String [] args) {
		System.out.format("integer size = %d , bytes =%d\n" , Integer.SIZE, Integer.BYTES);
		//hex();
		patterns();
		expPat();
		System.out.println(Integer.MAX_VALUE);
	}
}