class DynamicCircle extends Shape implements Scaler {

    private double r_;

    public DynamicCircle( double r ) {
	r_=r;
    }

    public void shrink(double s) {
	r_ *= (1.0 - s);
    }

    public void grow(double s ) {
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
	c.shrink(.1);
	print(c.area());
	c.grow(.1);
	print(c.area());
	
    }


}
