package test;

public class ValidationAlgorithm {

	public static boolean isUpperCase(String s) {
		return s.chars().allMatch(Character::isUpperCase);
		
	}
	
	private static boolean isLowerCase(String s) {
		return s.chars().allMatch(Character::isLowerCase);
		
	}
	public static void main(String args[]) {
		
		String character1 = "r";
		String character2 = "V";
		
		System.out.println(isUpperCase(character1));
		System.out.println(isLowerCase(character1));
		System.out.println(isUpperCase(character2));
		System.out.println(isLowerCase(character2));
		
	}
}
