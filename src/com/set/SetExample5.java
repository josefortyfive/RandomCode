package com.set;

import java.util.Set;
import java.util.HashSet;


public class SetExample5 {

	public static void main(String args[]) {
		
		Set<StudentInfo> name = new HashSet<>();
		
		StudentInfo student1 = new StudentInfo();
		student1.setFirstName("Edmar");
		student1.setLastName("Canin");
		
		StudentInfo student2 = new StudentInfo();
		student2.setFirstName("Arlene");
		student2.setLastName("Navales");
		
		
		name.add(student1);
		name.add(student2);
		
		System.out.println(name);
	}
}
