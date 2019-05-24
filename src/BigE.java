package Bytes;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class BigE {

	static public int getInt(ByteOrder order, byte[] b) {
		ByteBuffer bb = ByteBuffer.wrap(b);
		bb.order(order);
		return bb.getInt();	
	}
	
	static public byte [] getBytes( ByteOrder order ,int x) {
		byte [] b = new byte[4];
		ByteBuffer bb = ByteBuffer.wrap(b);
		bb.order(order);
		bb.putInt(x);
		return b;
	}
	
	static public void byteAssignExample() {
		byte b0 = 0x0f; // assign hex 
		byte b1 = 0b00001111; // assign binary
		System.out.println(b0);
		System.out.println(b1);
	}
	
	static public void littleE() {
		byte h = 0b1000000;
		System.out.println(h);
		byte [] ba = new byte[4];
		ba[0]=h;
		System.out.println(getInt(ByteOrder.BIG_ENDIAN,ba));
	}
	
	static public void test() {
		byte [] b = new byte[4];
		b[3]=1;
		
		ByteBuffer bb = ByteBuffer.wrap(b);
		bb.order(ByteOrder.LITTLE_ENDIAN);
		int i = bb.getInt();
		System.out.println(i);
	}
	
	static public void bitAssign() {
		int a = 0xffffffff;
		byte b = 0b1111111;
		for( int i =0 ; i < 8;i++) {
			int x = 2^i;
			byte bx = (byte)(b | (1 << i)) ;
			System.out.format("%d %d\n",x , bx);
		}
	}
	
	static void print( int v, byte [] b) {
		System.out.format( "value=%d : bytes=",v);
		for( int i = 0; i < b.length ; i++ )
			System.out.format(" %d",b[i]);
		System.out.format("\n");
	}
	
	static public void examineBytes(ByteOrder order) {
		int [] Values = { 0 , 1 , Integer.MAX_VALUE };
		for(int  v : Values) {
			print( v, getBytes(order,v));
		}
	}
	
	static public void main(String [] args) {
		System.out.println("starting BigE test ... ");
		System.out.format("%d %d\n",Integer.MAX_VALUE , Integer.MIN_VALUE);
		//bitAssign();
		examineBytes(ByteOrder.BIG_ENDIAN);
		examineBytes(ByteOrder.LITTLE_ENDIAN);
	}
	
}
