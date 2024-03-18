package test;

public class Employee {

	private String name;
	private int id;
	private int yearStarted;
	
	public Employee(String name, int id, int yearStarted) {
		super();
		this.name = name;
		this.id = id;
		this.yearStarted = yearStarted;
	}
	@Override
	public String toString() {
		return "%s %d %d".formatted(name, id, yearStarted);
	}
	
	
	
}
