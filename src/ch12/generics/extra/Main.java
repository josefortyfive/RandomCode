package ch12.generics.extra;

import java.util.List;
import java.util.ArrayList;
import ch12.generics.extra.model.*;

public class Main {
	
	public static void main(String args[]) {
		int studentCount = 10;
		List<Student> students = new ArrayList<>();
		
		for(int i = 0; i < studentCount; i++) {
			students.add(new Student());
		}
		printList(students);
		
	}

	public static void printList(List<Student> students) {
		for(var student : students) {
			System.out.println(student);
		}
		System.out.println();
	}
}
