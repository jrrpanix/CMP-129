import java.util.Scanner;

public class MathCalculator {

    
    public static double ADD( double x1 , double x2) {
	return x1 + x2;
    }
    
    public static double MULT( double x1, double x2) {
	return x1 * x2;
    }
    
    public static double SUB( double x1 , double x2) {
	return x1 - x2;
    }
    
    public static double GetResult( double x1 , double x2 ,char oc) {
	double result = 0;
	switch (oc) {
	case '+' : 
	    result = ADD(x1,x2);
	    break;
	case '-' : 
	    result = SUB(x1,x2);
	    break;
	case '*' :
	    result = MULT(x1,x2);
	    break;
	}
	return result;
    }
    
    public static boolean isValidOp( String op) {
	return op.equals("+") || op.equals("-") || op.equals("*");
    }
    
    public static boolean processInput( Scanner keyboard) {
	double x1 = 0;
	if ( keyboard.hasNextDouble()) x1 = keyboard.nextDouble();
	else return false;
	double x2 = 0;
	if ( keyboard.hasNextDouble()) x2 = keyboard.nextDouble();
	else return false;
	String op;
	if ( keyboard.hasNext()) op = keyboard.next();
	else return false;
	if ( !isValidOp( op)) return false;
	double result = GetResult(x1,x2,op.charAt(0));
	System.out.println( result );
	return true;
    }
    
    public static void mathCalculator() {
	System.out.println("Starting mathCalculator...");
	Scanner keyboard = new Scanner( System.in);
	boolean moreInput = true;
	while( moreInput) {
	    moreInput = processInput( keyboard );
	}
	keyboard.close();
	System.out.println("Stopping mathCalculator...");
    }
    
    public static void main( String [] args){
	mathCalculator();
    }
}
