package com.collection.map;

import java.util.*;

class MapExample5 {
	public static void main(String args[]) {
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(100, "Maya");
		map.put(101, "Michael");
		map.put(102, "Raul");
		// Returns a Set view of the mappings contained in this map
		map.entrySet()
				// Returns a sequential Stream with this collection as its source
				.stream()
				// Sorted according to the provided Comparator
				.sorted(Map.Entry.comparingByValue())
				// Performs an action for each element of this stream
				.forEach(System.out::println);
	}
}