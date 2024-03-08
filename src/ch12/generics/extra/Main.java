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
		
		students.add(new LPAStudents());
		printList(students);
		
		List<LPAStudents> lpastudents = new ArrayList<>();
		
		for(int i = 0; i < studentCount; i++) {
			lpastudents.add(new LPAStudents());
		}
		printList(lpastudents);
	}

	public static void printList(List students) {
		for(var student : students) {
			System.out.println(student);
		}
		System.out.println();
	}
}
