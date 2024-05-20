package ch15.collection;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Collection;

public class Example1 {

	public static void main(String args[]) {
		Collection<String> list = new HashSet<>();
		
		String[] names = {"Anna", "Bob", "Carol", "Danna", "Ed"};
		list.addAll(Arrays.asList(names));
		System.out.println(list);
		
		list.add("Fred");
		list.addAll(Arrays.asList("George", "Gary", "Grace"));
		System.out.println(list);
		System.out.println("Gary is in the list " +list.contains("Gary"));
		
		list.removeIf(s -> s.charAt(0) == 'G');
		System.out.println(list);
		System.out.println("Gray in the list " +list.contains("Gary"));
	}
}
