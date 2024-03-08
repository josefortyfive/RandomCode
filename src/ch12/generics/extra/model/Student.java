package ch12.generics.extra.model;

import java.util.Random;
public class Student {
	
	private String name;
	private String course;
	private int yearStarted;
	
	protected static Random random = new Random();
	
	private static String[] firstNames = {"Ann", "Bill", "Cathy", "John", "Tim"};
	private static String[] courses = {"c++", "java", "Python"};
	
	public Student() {
		int lastNameIndex = random.nextInt(65, 91);
		name = firstNames[random.nextInt(5)] + " " +(char) lastNameIndex;
		course = courses[random.nextInt(3)];
		yearStarted = random.nextInt(2018, 2023);
	}

	public String toString() {
		return "%-15s %-15s %d".formatted(name, course, yearStarted);
	}
	

	public int getYearStarted() {
		return yearStarted;
	}
	
}
