package test;

import java.util.ArrayList;
import java.util.Arrays;
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
		
		
		System.out.println(reverse1(null));
		System.out.println(reverse1(""));
		System.out.println(reverse1("hello"));
		System.out.println(reverse1("tacos"));
		System.out.println(reverse1("Hi!"));
		
		int arr[] = {1, 2, 3, 4, 5, 6};
		
		Arrays.stream(reverse2(arr)).forEach(System.out::println);
	}
	
	public static int[] reverse2(int arr[]) {
		int[] result = new int[arr.length];
		
		for(int i = 0; i < arr.length; i++) {
			result[i] = arr[arr.length - 1 - i];
		}
		
		return result;
	}
	
	private static String reverse1(String s) {
		
		if(s == null || s.isEmpty()) {
			return s;
		}
		StringBuilder sb = new StringBuilder(s);
		return sb.reverse().toString();
		
	}
	private static void addMoreAnimal(LinkedList<String> animal) {
		animal.add("Fox");
		animal.add("Salamander");
		
		System.out.println(animal);
		
		String s = "LL";
		System.out.println(s.contains("LL"));
	}
	
	//private static void getAnimal(LinkedList<String> animal) {
		
		//System.out.println("The last animal in the list is: "+animal.getLast());
	//}
}
