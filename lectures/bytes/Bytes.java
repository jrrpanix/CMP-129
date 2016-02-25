package bytes;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class Bytes {

    /*
      This Example show the Bytes that Make Up a Character
      and then switches the Byte Ordering
      
     */
    static public void switchByteOrder() {
	char [] ca = {'A'};
	byte [] ba = {0,0};
	ByteBuffer bb = ByteBuffer.wrap(ba);
	bb.putChar(ca[0]);
	bb.rewind();
	System.out.println(bb.get() + " " + bb.get());
	bb.rewind();
	System.out.println(bb.getChar() + " " + ByteOrder.BIG_ENDIAN);
	bb.rewind();
	bb.order(ByteOrder.LITTLE_ENDIAN);
	System.out.println(bb.getChar() + " " + ByteOrder.LITTLE_ENDIAN );
    }

}