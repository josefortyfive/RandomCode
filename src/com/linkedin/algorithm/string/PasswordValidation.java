package com.linkedin.algorithm.string;

public class PasswordValidation {

	private static boolean isPasswordComplex(String s) {
		return s.chars().anyMatch(Character::isUpperCase) &&
				s.chars().anyMatch(Character::isLowerCase) &&
				s.chars().anyMatch(Character::isDigit);
	}
	
	public static void main(String args[]) {
		System.out.println(isPasswordComplex("Hell0"));
		System.out.println(isPasswordComplex("Hello"));
		System.out.println(isPasswordComplex("hello"));
		System.out.println(isPasswordComplex("HeLLo"));
		System.out.println(isPasswordComplex("h3lLo"));
		
	}
}
