package ch12.generics.example2;

import java.util.Arrays;

public class Main {

	public static void main(String args[]) {
		Integer five = 5;
		Integer[] others = {0, 5, 10, -50, 50};
		
		for(Integer i : others) {
			int val = five.compareTo(i);
			System.out.printf("%d %s %d: compareTo=%d%n", five, 
					(val == 0 ? "==" :(val < 0) ? "<" : ">"), i, val);
		}
		
		String banana = "banana";
		String[] fruit = {"apple", "banana", "pear", "BANANA"};
		
		for(String s : fruit) {
			int val = banana.compareTo(s);
			System.out.printf("%s %s %s: comparTo=%d%n", banana, 
					(val == 0 ? "==" : (val < 0) ? "<" : ">"), s, val);
		}
		Arrays.sort(fruit);
		System.out.println(Arrays.toString(fruit));
		
		System.out.println("A:" +(int)'A' + " " + "a:" +(int)'a');
		System.out.println("B:" +(int)'B' + " " + "b:" +(int)'b');
		System.out.println("P:" +(int)'P' + " " + "p:" +(int)'p');
		
		Student ed = new Student ("Ed");
		Student[] students = {new Student("Tim"), new Student("Ned"),
				new Student("Anne")};
		Arrays.sort(students);
		System.out.println(Arrays.toString(students));
		
		System.out.println("result = " +ed.compareTo("MAry"));
	}
}

class Student implements Comparable {
	private String name;

	public Student(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}

	@Override
	public int compareTo(Object o) {
		Student other = (Student) o;
		return name.compareTo(other.name);
	}
	
	
	
}
