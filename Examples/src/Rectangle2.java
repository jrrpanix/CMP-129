
/*
  This class shows the effect of not checking for the correct object 
  in a call to equals(Object) method
*/


public class Rectangle2 {
	
    private double l_;
    private double w_;
    private static boolean skipClassCheck = false;
    
    public Rectangle2( double l , double w ) {
	l_=l; 
	w_=w;
    }
    
    public Rectangle2( Rectangle2 x) {
	l_=x.l_;
	w_=x.w_;
    }
    
    public boolean equals( Object xo) {
	System.out.print("equals(Object) called");
	if ( !skipClassCheck && xo.getClass() != Rectangle.class) return false;
	Rectangle2 x = (Rectangle2)xo;
	return l_ == x.l_ && w_== x.w_;
    }
    
    public boolean equals( Rectangle2 x ) {
	System.out.print("equals(Rectangle2) called");
	return l_ == x.l_ && w_== x.w_;
    }
    
    public static void setSkipClassCheck( boolean x ) {
	skipClassCheck = x;
    }
    
    
    
    public static void main( String [] args  ) {
	Rectangle2 r0 = new Rectangle2( 2,2);
	Rectangle2 r1 = new Rectangle2(r0);
	
	Object o1 = r0;
	Object o2 = r1;
	
	System.out.println( " :o1.equals(o2)=" + o1.equals(o2));
	System.out.println( " :r1.equals(r2)=" + r0.equals(r1));
	
	String s1 = new String("xyz");
	System.out.println( " :r0.equals(s1)=" +r0.equals(s1));
	
	System.out.println("Rectangle2.setSkipClassCheck(true)");
	Rectangle2.setSkipClassCheck(true);
	String s2 = new String("xyz");
	System.out.println( r0.equals(s2));
    }
}

/*
equals(Object) called :o1.equals(o2)=false
equals(Rectangle2) called :r1.equals(r2)=true
equals(Object) called :r0.equals(s1)=false
Rectangle2.setSkipClassCheck(true)
equals(Object) calledException in thread "main" java.lang.ClassCastException: java.lang.String cannot be cast to Rectangle2
	at Rectangle2.equals(Rectangle2.java:20)
	at Rectangle2.main(Rectangle2.java:51)
*/

