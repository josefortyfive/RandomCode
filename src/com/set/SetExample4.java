package com.set;

import java.util.HashSet;
import java.util.Set;

public class SetExample4 {

	public static void main(String args[]) {
        // Creating an object of Set and 
        // declaring object of type String
        Set<String> hs = new HashSet<String>();

        // Adding elements to above object
        // using add() method
        hs.add("B");
        hs.add("B");
        hs.add("C");
        hs.add("A");

        // Printing the elements inside the Set object
        System.out.println(hs);
        
        
        Set<String> ha = new HashSet<String>();

        // Adding elements to above object
        // using add() method
        ha.add("Z");
        ha.add("Z");
        ha.add("X");
        ha.add("Y");

        // Printing the elements inside the Set object
        System.out.println(ha);
        
        
        
        
        Set<String> he = new HashSet<String>();

        // Adding elements to above object
        // using add() method
        he.add("Q");
        he.add("P");
        he.add("S");
        he.add("R");

        // Printing the elements inside the Set object
        System.out.println(he);
        
        
        Set<String> hi = new HashSet<String>();

        // Adding elements to above object
        // using add() method
        hi.add("T");
        hi.add("U");
        hi.add("S");
        hi.add("S");

        // Printing the elements inside the Set object
        System.out.println(hi);
	}
}
