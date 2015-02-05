// Class      : CMP-129
// Assignment : Triangle
// Due        : 2/4/2015
// Instructor : JReynolds


public class Triangle {
    private double base_;
    private double height_;

    //---------------------------------------
    // Constructors
    //---------------------------------------
    // default constructor
    public Triangle() {
	base_=0;
	height_=0;
    }

    public Triangle(double base, double height) {
	base_=base;
	height_=height;
    }
    
    // copy constructor
    public Triangle(Triangle x) {
	base_=x.base_;
	height_=x.height_;
    }

    //---------------------------------------
    // overriding object methods
    //---------------------------------------
    public String toString() {
	return new String( "Triangle:"+ base_ + ":" +height_);
    }

    public int hashCode() {
	return new Double( base_).hashCode() ^ new Double(height_).hashCode() ;
    }


    public boolean equals( Object x ) {
	if ( x.getClass() != Triangle.class ) return false;
	return equals( (Triangle)x);
    }

    //---------------------------------------
    // Triangle specific
    //---------------------------------------
    public boolean equals( Triangle x ) {
	return base_ == x.base_ && height_ == x.height_;
    }

    public double area() {
	return 0.5 * base_ * height_;
    }

    public double getBase() {
	return base_;
    }

    public double getHeight() {
	return height_;
    }



}

