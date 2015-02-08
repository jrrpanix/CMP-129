public class Person {

    protected String lastName_;
    protected String firstName_;

    public Person() {
    }

    public Person( String last , String first ) {
	lastName_=last;
	firstName_=first;
    }

    public Person( Person x ) {
	lastName_=x.lastName_;
	firstName_=x.firstName_;
    }

    public String toString() {
	return new String( "Person:" + lastName_ + ":" + firstName_);
    }

    public String getLastName() {
	return lastName_;
    }

    public String getFirstName() {
	return firstName_;
    }

    

}
