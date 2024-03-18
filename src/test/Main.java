package test;

import java.util.List;
import java.util.ArrayList;

public class Main {

	public static void main(String args[]) {
		Employee employee = new Employee("Ed", 1, 2021);
		List<Employee> emp = new ArrayList<>();
		
		for(Employee i : emp) {
			System.out.println(i);
		}
	}
}
