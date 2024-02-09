package test;

import java.util.ArrayList;
import java.util.LinkedList;

public class Test {

	public static void main(String args[]) {
		
		LinkedList<String> animal = new LinkedList<>();
		animal.add("Dog");
		animal.add("Cat");
		animal.add("Bird");
		
		System.out.println(animal);
		
		addMoreAnimal(animal);
		
		System.out.println("The last animal in the list is "+animal.getLast());
		
		
	}
	
	private static void addMoreAnimal(LinkedList<String> animal) {
		animal.add("Fox");
		animal.add("Salamander");
		
		System.out.println(animal);
		
	}
	
	//private static void getAnimal(LinkedList<String> animal) {
		
		//System.out.println("The last animal in the list is: "+animal.getLast());
	//}
}
