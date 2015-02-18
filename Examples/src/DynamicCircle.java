class DynamicCircle extends Shape implements Scaler {

    private double r_;

    public DynamicCircle( double r ) {
	r_=r;
    }

    public void decrease(double s) {
	r_ *= (1.0 - s);
    }

    public void increase(double s ) {
	r_ *= (1.0 + s );
    }
    
    public double area() {
	return Math.PI * r_ * r_;
    }

    public double perimeter() {
	return 2.0 * Math.PI * r_;
    }

    public static void print( double x ) {
	System.out.println(x);
    }

    public static void main( String [] args ) {
	DynamicCircle c = new DynamicCircle(10);
	print(c.area());
	c.decrease(.1);
	print(c.area());
	c.increase(.1);
	print(c.area());
	
    }


}
