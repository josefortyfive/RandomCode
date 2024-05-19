package test;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
public class Example1 {
	public static void main(String args[]) {
		List<Person> listSample = new ArrayList<>(Arrays.asList(
				new Person("Ed", 124, "M"),
				new Person("Lene", 124, "f")
				
				));
		listSample.forEach(s -> System.out.println(s));
	}
}
