package gui;
//------------------------------------------
//class      : CMP-129
//instructor : JReynolds
//DataGen generates data for a function
//and computes the bounds for easier graphing
//------------------------------------------
public class DataGen {

 public double [] X;
 public double [] Y;

 public double maxX;
 public double minX;
 public double maxY;
 public double minY;
 public FuncInterface fi;

 public DataGen() {
 }
 
 public DataGen( double lBound , double uBound , int N , FuncInterface f ) {
	fi=f;
	X = new double[N];
	Y = new double[N];
	gen( lBound , uBound , f );
	setBounds();
 }

 public DataGen( double [] X , double [] Y ) {
	this.X = X;
	this.Y = Y;
	setBounds();
 }

 public void generate( double lBound , double uBound , int N , FuncInterface f ) {
	fi=f;
	X = new double[N];
	Y = new double[N];
	gen( lBound , uBound , f );
	setBounds();
 }

 public void printData() {
	for( int i = 0; i < X.length ; i++ ) {
	    System.out.format( "%12.6f,%12.6f\n",X[i],Y[i]);
	}
 }

 public int size() {
	return X.length;
 }

 private void gen( double lBound , double uBound ,  FuncInterface f ) {
	double step = (uBound - lBound)/(X.length-1);
	double x = lBound;
	for( int i = 0; i < X.length ; i++ ) {
	    X[i]=x;
	    Y[i]=f.calc(x);
	    x += step;
	}
 }

 private void setBounds() {
	maxX = maxV(X);
	minX = minV(X);
	maxY = maxV(Y);
	minY = minV(Y);
 }

 private double maxV( double [] V ) {
	double m = V.length > 0 ? V[0] : 0;
	for( int i = 1 ; i < V.length ; i++ )
	    if ( V[i] > m ) m = V[i];
	return m;
 }

 private double minV( double [] V ) {
	double m = V.length > 0 ? V[0] : 0;
	for( int i = 1 ; i < V.length ; i++ )
	    if ( V[i] < m ) m = V[i];
	return m;
 }

 public static void runTest( DataGen gen ) {
	System.out.println(gen.fi);
	gen.printData();
 }

 //------------------------------------------
 //------------------------------------------
 public static void main( String [] args ) {
	runTest( new DataGen(0 , 5 , 10 , new ExpF() ) );
	runTest( new DataGen(1 , 10 , 10 , new LogF() ) );
	runTest( new DataGen(0 , Math.PI*2, 13 , new SinF() ) );
 }

}

//------------------------------------------
//------------------------------------------
class ExpF implements FuncInterface {
 public double calc( double x ) {
	return Math.exp(x);
 }
 public String toString() {
	return "Math.exp()";
 }
}

class LogF implements FuncInterface {
 public double calc( double x ) {
	return Math.log(x);
 }
 public String toString() {
	return "Math.log()";
 }
}

class SinF implements FuncInterface {
 public double calc( double x ) {
	return Math.sin(x);
 }
 public String toString() {
	return "Math.sin()";
 }
}
