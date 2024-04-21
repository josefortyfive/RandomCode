package test;

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
	
	public static void main(String args[]) {
		System.out.println(findMaximumNumber(1, 2, 3));
		System.out.println(findMaximumNumber(5, 20, 33));
		System.out.println(findMaximumNumber(40, 12, 6));
		System.out.println(findMaximumNumber(8, 55, 35));
		
	}
}
