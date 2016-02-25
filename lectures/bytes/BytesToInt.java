
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class BytesToInt {
    
    public static String asString( byte [] ba) {
	if ( ba.length == 0) return "";
	String s = Integer.toString(ba[0]);
	for( int i =1; i < ba.length; i++) {
	    s += String.format(" %3d", ba[i]);
	}
	return s;
    }
    
    /*
     * Get the Bytes that Make up and Integer
     * 
     */
    public static byte [] getBytes( int value , ByteOrder order) {
	byte [] ba = new byte[Integer.BYTES];
	ByteBuffer bb = ByteBuffer.wrap(ba);
	bb.order(order);
	bb.putInt(value);
	return ba;
    }
    
    /*
     * Convert an array of Bytes to an Integer
     * 
     */
    
    public static int getInt( byte [] ba, ByteOrder order) {
	ByteBuffer bb = ByteBuffer.wrap(ba);
	bb.order(order);
	return bb.getInt();
    }
    
    public static  byte [] ba( int ...bytes ){
	byte [] b = new byte[bytes.length];
	for( int i =0; i < bytes.length;i++)b[i]=(byte)bytes[i];
	return b;
    }
    
    public static void clear(byte [] bytes) {
	for( int i= 0; i < bytes.length ; i++) bytes[i]=0;
    }
    
    public static void set( byte [] ba , String bins) {
	clear(ba);
	for( int i =0; i < bins.length();i++) {
	    ba[i] = (byte)(bins.charAt(i) == '0' ? 0 : 1);
	}
    }
    
    public static void print( byte [] ba) {
	String bstr = asString(ba);
	int valBE = getInt( ba , ByteOrder.BIG_ENDIAN);
	int valLE = getInt( ba , ByteOrder.LITTLE_ENDIAN);
	System.out.format("%14s %14d %14d\n", bstr, valBE,valLE);
    }
    
    public static void example0(){
	print( ba(0,0,0,1));
	print( ba(0,1,1,0));
	print( ba(1,0,0,1));
	print( ba(0,1,1,1));
	print( ba(1,1,1,1));
	print( ba(127,0,0,0));
	print( ba(0,0,0,-127));
	print( ba(0,0,0,-1));
	print( ba(-128,0,0,0));
    }
    
    public static void example1(){
	for( byte b = -128 ; b < 127; b++) {
	    print(ba(0,0,0,b));
	}
	
    }
    
    public static void example(){
	for( int i = -255 ; i <= 255 ; i++) {
	    byte [] ba = getBytes(i,ByteOrder.BIG_ENDIAN);
	    String bstr = asString(ba);
	    int vBE = getInt(ba,ByteOrder.BIG_ENDIAN);
	    int vLE = getInt(ba,ByteOrder.LITTLE_ENDIAN);
	    System.out.format("%14d %14s %14d %14d\n", i,bstr,vBE,vLE);
	}
	
    }
    
    
    public static void main(String [] args ) {
	example();
    }
}

