package test;

import java.util.ArrayList;

public class PersonTest {
	
	public static void main(String args[]) {
		ArrayList<Person> list = new ArrayList<>();
		list.add(new Person("Ed", 29, "m"));
		list.add(new Person("Lene", 27, "f" ));
		list.add(new Person("Jenny", 21, "f"));
				
		
		
		System.out.println(list);

		
		
	}

}
