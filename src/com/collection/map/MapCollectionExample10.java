package com.collection.map;

import java.util.Map;
import java.util.HashMap;

public class MapCollectionExample10 {
	
	public static void main(String args[]) {
		Map<Integer,String> hm1 = new HashMap<>();
		
		Map<Integer, String> hm2 = new HashMap<Integer, String> ();
		
		hm1.put(1, "Ed");
		hm1.put(2, "Lene");
		hm1.put(3, "Stacy");
		
		hm2.put(new Integer(1), "Edie");
		hm2.put(new Integer(2), "war");
		hm2.put(new Integer(3), "do");
		
		System.out.println(hm1);
		System.out.println(hm2);
	}

}
