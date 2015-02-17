import java.util.Random;
import java.io.File;
import java.util.Scanner;

public class TestShape {

    public static Shape [] ReadShapeFile( String fileName ) {
	Shape [] shapeArray = null ;
	try {
	    File file = new File( fileName );
	    Scanner scan = new Scanner(file);
	    int NShapes= scan.hasNextInt() ? scan.nextInt() : 0;
	    shapeArray = new Shape[NShapes];
	    for(int i=0; i < NShapes  ;i++ ) {
		String shapeType = scan.next();
		if ( shapeType.equals("Circle") ) {
		    double r = scan.nextDouble();
		    shapeArray[i] = new Circle(r);
		}
		else if ( shapeType.equals("Rectangle")) {
		    double l = scan.nextDouble();
		    double w = scan.nextDouble();
		    shapeArray[i] = new Rectangle(l,w);
		}
	    }
	}
	catch( java.io.FileNotFoundException e) {
	    System.out.println(e);
	}
	return shapeArray;
    }

    public static double computeTotalArea( Shape [] shapes ) {
	double total = 0;
	for ( Shape s : shapes )
	    total += s.area();
	return total;
    }

    public static void main( String [] args ) {
	if ( args.length != 1 ) {
	    System.out.println( "unable to test need file");
	    return;
	}
	String fileName = args[0];
	Shape [] shapes = ReadShapeFile( fileName );
	double total = computeTotalArea(shapes);
	System.out.println( "Total Area of " + shapes.length + " Shapes is " + total);
    }

}

/*
Example File 

5
Circle 5
Rectangle 10 4
Circle 4
Rectangle 9 8
Circle 3
Circle 2

Output 

Total Area of 5 Shapes is 269.0796326794897

*/

