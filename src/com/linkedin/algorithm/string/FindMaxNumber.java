package com.linkedin.algorithm.string;

public class FindMaxNumber {

	private static int findMaximumNumber(int a, int b, int c) {
		if(a > b) {
			if(a > c || a == c) {
				return a;
			}
		}
		
		if(b > c) {
			return b;
		}
		
		return c;
	}
	
	private static int findMaximumNumber2(int a, int b, int c) {
		int max = a;
		
		if(b > max) {
			max = b;
		}
		if(c > max ) {
			max = c;
		}
		
		return max;
	}
	
	public static void main(String args[]) {
		
		// implementation of max number
		System.out.println(findMaximumNumber(1, 2, 3));
		System.out.println(findMaximumNumber(5, 20, 33));
		System.out.println(findMaximumNumber(40, 12, 6));
		System.out.println(findMaximumNumber(8, 55, 35));
		
		// implementation of max number more efficient
		System.out.println("");
		
		System.out.println(findMaximumNumber2(1, 2, 3));
		System.out.println(findMaximumNumber2(5, 20, 33));
		System.out.println(findMaximumNumber2(40, 12, 6));
		System.out.println(findMaximumNumber2(8, 55, 35));
		
	}
}
