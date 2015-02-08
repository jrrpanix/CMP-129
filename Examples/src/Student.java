public class Student extends Person {

    protected long    id_;
    protected String  school_;

    public Student() {
    }

    public Student( String last , String first , long id , String school ) {
	super( last , first );
	id_=id;
	school_=school;
    }

    public String toString() {
	return new String( "Student:" + super.toString() + ":" + id_ + ":" + school_);
    }

    public long getId() {
	return id_;
    }
    
    public String getSchool() {
	return school_;
    }
}
