package com.stack;

import java.util.Stack;
import java.util.stream.Stream;

public class StackExample5 {

	public static void main(String[] args) {
		Stack<String> stack = new Stack<String>();
		stack.push("A");
		stack.push("B");
		stack.push("C");
		stack.push("D");

		Stream<String> stream = stack.stream();

		stream.forEach((element) -> {
		    System.out.println(element);  // print element
		});

	}

}
