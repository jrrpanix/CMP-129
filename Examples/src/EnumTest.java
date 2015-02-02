class EnumTest {

    public static void printEnum( Months m ) {
	System.out.println( "name=" + m.name() + ":toString()="+m.toString() + ":ordinal()=" + m.ordinal() );
    }

    public static void testEqual( Months m0 , Months m1 ) {
	System.out.println( "m0.equals(m1)="+m0.equals(m1)+" where m0=" +m0.name() + " and m1=" + m1.name() );

    }
    public static void main( String [] args ) {
	Months j0 = Months.Jan;
	Months j1 = Months.Jan;
	Months d0 = Months.Dec;
	printEnum( Months.Jan );
	printEnum( Months.Dec );
	testEqual(j0,j1);
	testEqual(j0,d0);
	System.out.println( "(j0 == j1)=" + (j0==j1) +" where j0=" +j0.name() + " and j1=" + j1.name() );

	System.out.println( d0.compareTo( j0 ));
    }
}
