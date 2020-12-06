package solidprinciples;

public class Employee {

	long id;
	String firstName;
	String lastName;

	public Employee (long idn, String pname, String lname) {
		this.id = idn;
		this.firstName = pname;
		this.lastName = lname;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public long getId() {
		return id;
	}
}