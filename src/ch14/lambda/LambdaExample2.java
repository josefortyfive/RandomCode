package ch14.lambda;

import java.util.Arrays;
import java.util.function.Function;
import java.util.function.Consumer;

import java.util.function.Predicate;

public class LambdaExample2 {
	public static void main(String args[]) {
		String name = "Edmar";
		Function<String, String> uCase = String::toUpperCase;
		System.out.println(uCase.apply(name));
		
		Function<String, String> lastName = s -> s.concat(" Canin");
		Function<String, String> uCaseLastName = uCase.andThen(lastName);
		System.out.println(uCaseLastName.apply(name));
		
		uCaseLastName = uCase.compose(lastName);
		System.out.println(uCaseLastName.apply(name));
		
		Function<String, String[]> f0 = uCase
				.andThen(s -> s.concat(" Canin"))
				.andThen(s -> s.split(" "));
		System.out.println(Arrays.toString(f0.apply(name)));
		
		Function<String, String> f1 = uCase
				.andThen(s -> s.concat(" Canin"))
				.andThen(s -> s.split(" "))
				.andThen(s -> s[1].toUpperCase() + ", " +s[0]);
		System.out.println(f1.apply(name));
		
		Function<String, Integer> f2 = uCase
				.andThen(s -> s.concat(" Canin"))
				.andThen(s -> s.split(" "))
				.andThen(s -> String.join(", ", s))
				.andThen(String::length);
		System.out.println(f2.apply(name));
		
		String[] names = {"Ann", "Bob", "Carol" };
		Consumer<String> s0 = s -> System.out.print(s.charAt(0));
		Consumer<String> s1 = System.out::println;
		Arrays.asList(names).forEach(s0 
				.andThen(s -> System.out.print(" - "))
				.andThen(s1));
	
		Predicate<String> p1 = s -> s.equals("EDMAR");
		Predicate<String> p2 = s -> s.equalsIgnoreCase("Edmar");
		Predicate<String> p3 = s -> s.startsWith("E");
		Predicate<String> p4 = s -> s.startsWith("r");
		
		
		Predicate<String> combined1 = p1.or(p2);
		System.out.println("combined1 = " +combined1.test(name));
		
		Predicate<String> combined2 = p3.or(p4);
		System.out.println("combined1 = " +combined2.test(name));
		
		Predicate<String> combined3 = p3.and(p4).negate();
		System.out.println("combined3 = " +combined3.test(name));
	}
}
