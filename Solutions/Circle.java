// Class      : CMP-129
// Assignment : Circle
// Due        : 2/4/2015
// Instructor : JReynolds


public class Circle {
    private double radius_;

    //---------------------------------------
    // Constructors
    //---------------------------------------
    // default constructor
    public Circle() {
	radius_=0;
    }

    public Circle(double r) {
	radius_=r;
    }
    
    // copy constructor
    public Circle(Circle x) {
	radius_=x.radius_;
    }

    //---------------------------------------
    // overriding object methods
    //---------------------------------------
    public String toString() {
	return new String( "Circle:"+ radius_);
    }

    public int hashCode() {
	return new Double( radius_).hashCode();
    }


    public boolean equals( Object x ) {
	if ( x.getClass() != Circle.class ) return false;
	return equals( (Circle)x);
    }

    //---------------------------------------
    // Circle specific
    //---------------------------------------
    public boolean equals( Circle x ) {
	return radius_ == x.radius_;
    }

    public double area() {
	return Math.PI * radius_ * radius_;
    }

    public double getRadius() {
	return radius_;
    }



}

