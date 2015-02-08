public class Employee extends Person {

    protected String employer_;

    public Employee( String last , String first , String employer ) {
	super(last,first);
	employer_=employer;
    }

    public Employee() {
    }

    public String toString() {
	return new String( "Employee:" + super.toString() + ":" +employer_);
    }


}
