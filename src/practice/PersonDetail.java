package practice;

public class PersonDetail {

	private String firstName;
	private String lastName;
	private String email;
	
	public PersonDetail(String firstName, String lastName, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	@Override
	public String toString() {
		return "The name of the person is %s %s with email: %s ".formatted(firstName, lastName, email);
	}
	
	
	
	
}
