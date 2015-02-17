// Course      : CMP-129
// Title       : Rectangle , Introduction to desinging Classes in Java
// Instructor  : JReynolds


public class Rectangle extends Shape {

    
    //-----------------------------------------
    // Constructors
    //-----------------------------------------
    public Rectangle() { // Default
	len_=0;
	width_=0;
	instanceCount_++;
    }

    public Rectangle( Rectangle orig ) { // Copy
	this.len_=orig.len_;
	this.width_=orig.width_;
	instanceCount_++;
    }

    public Rectangle( double l , double w) {
	len_=l;
	width_=w;
	instanceCount_++;
    }
    
    //-----------------------------------------
    // Methods from Object that are over rides
    //-----------------------------------------
    public String toString() {
	String s= new String( "Rectangle:"+len_+":"+width_);
	return s;
    }
    
    public Object clone() {
	return new Rectangle(len_,width_);
    }
    
    public void finalize() {
	// may never get called!
	// only gets called if Garbage Collector invoked! 
	// not necesary to override for this class!
    }
    
    public boolean equals( Object o) {
	// Note we check to see if Object is of type Rectangle.class
	// before casting to a Rectangle
	if ( o.getClass() != Rectangle.class ) return false;
	return equals((Rectangle)o);
    }


    public int hashCode() {
	// do "^" operation aka "Exclusive OR"
	return new Double(len_).hashCode() ^ new Double(width_).hashCode();
    }

    //-------------------------------------------
    // Specific methods (instance functions) for Rectangle
    //-------------------------------------------

    public double area() {
	return len_*width_;
    }

    public double perimeter() {
	return 2*len_ + 2*width_;
    }

    public double getLen() {
	return len_;
    }

    public double getWidth() {
	return width_;
    }

    public boolean equals( Rectangle r) {
	return this.len_ == r.len_ && this.width_ == r.width_;
    }

    //-------------------------------------------
    // static funcitons 
    //-------------------------------------------
    public static long getInstanceCount() {
	return instanceCount_;
    }

    //-------------------------------------------
    // member variables aka instance variables
    //-------------------------------------------
    private double len_    ;
    private double width_  ;

    // static variable to count number of instances
    private static long instanceCount_=0 ;
    
    //-------------------------------------------
    // Test Rectangle Code
    //-------------------------------------------
    public static void UnitTest() {
	System.out.println( "Rectangle Unit Test\n" );

	Rectangle R0 = new Rectangle(5,10);
	System.out.println( R0.toString() + ":area=" + R0.area() + ":class=" + R0.getClass() + ":hash=" + R0.hashCode() );

	Rectangle R1 = (Rectangle)R0.clone();
	System.out.println( "\nClone Rectangle: Verify Fields:");
	System.out.println( R1.toString() + ":area=" + R1.area() + ":class=" + R1.getClass() + ":hash=" + R1.hashCode() );

	System.out.println( "\nVerify equal and hashCode" );
	System.out.print( "R0.equals(R1)=" + R0.equals(R1));
	System.out.print( ":R0.hashCode()="+R0.hashCode());
	System.out.println( ":R1.hashCode()="+R1.hashCode());
	System.out.println( "Area="+R1.area() + ":check Area=" + R1.getLen() * R1.getWidth());

	System.out.println( "\nCreate a different Rectangle");
	Rectangle R2 = new Rectangle(10,5);
	System.out.println( R2.toString() + ":area=" + R2.area() + ":class=" + R2.getClass() + ":hash=" + R2.hashCode() );
	System.out.println( "R2.equals(R1)=" + R2.equals(R1));

	Rectangle R2c = new Rectangle(R2);
	System.out.println("\nVerify Copy Constructor");
	System.out.println( R2c.toString() + ":area=" + R2c.area() + ":class=" + R2c.getClass() + ":hash=" + R2c.hashCode() );

	System.out.println("\nVerify Default Constructor");
	Rectangle R3 = new Rectangle();
	System.out.println( R3.toString() + ":area=" + R3.area() + ":class=" + R3.getClass() + ":hash=" + R3.hashCode() );

	System.out.println( "\nInstance Count = " + Rectangle.getInstanceCount() );
	System.out.println( R3.getInstanceCount() + " = "  + R1.getInstanceCount() );
	System.out.println( "Calling equals(Object) " + R0.equals((Object)R1) );

    }
    
    //-------------------------------------------
    // main
    //-------------------------------------------
    public static void main(String[] args) {
	UnitTest();
    }



}

