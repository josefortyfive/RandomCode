package com.linkedin.collections.tree;

import java.util.Arrays;

import java.util.List;
import java.util.NavigableSet;

import java.util.TreeSet;


public class Application {

	public static void main(String args[]) {
		
		List<Integer> numbers = Arrays.asList(500, 1500, 2500, 1000, 3000, 200);
		
		NavigableSet<Integer> numberTree = new TreeSet<>(numbers);
		
		System.out.println(numberTree.lower(750));
	}
}
