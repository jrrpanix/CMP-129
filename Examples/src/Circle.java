// Course      : CMP-129
// Title       : class Circle extends Shape
// Instructor  : JReynolds

public class Circle extends Shape {
    private double radius_;

    public Circle() {
	radius_=0;
    }

    public Circle( long id , double r ) {
	super(id);
	radius_=r;
    }

    public Circle( double r  ) {
	radius_=r;
    }

    public Circle( Circle c ) {
	super(c);
	radius_=c.radius_;
    }

    public double area() {
	return Math.PI * radius_ * radius_;
    }

    public double perimeter() {
	return 2.0 *Math.PI * radius_;
    }

    public String toString() {
	return new String( "Circle:id=" + super.id_ + ":radius=" + radius_);
    }

    // test
    public static void main( String [] args ) {
	Circle c = new Circle( 1, 3.3 );
	System.out.println(c + ":area=" +c.area() +":perimeter=" + c.perimeter() );
    }

}