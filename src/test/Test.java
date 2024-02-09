package test;

import java.util.ArrayList;

public class Test {

	public static void main(String args[]) {
		
		ArrayList<Integer> intList = new ArrayList<>(10);
		
		for(int i = 0 ; i < 7; i++) {
			intList.add((i + 1) * 5);
		}
		
		System.out.println(intList);
	}
}
