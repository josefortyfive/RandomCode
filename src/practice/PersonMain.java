package practice;

import java.util.ArrayList;
import java.util.List;

public class PersonMain {
	
	public static void main(String args[]) {
		
		List<PersonDetail> person = new ArrayList<>();
		
		person.add(new PersonDetail("Edmar", "Canin", "edmar@java.com"));
		person.add(new PersonDetail("Arlene", "Navales", "arlene@java.com"));
		
		
		System.out.println(person);
		
	}

}
