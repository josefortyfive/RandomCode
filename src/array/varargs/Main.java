package array.varargs;

public class Main {

	public static void main(String... args) {
		System.out.println("Hello World again");
		
		String[] splitStrings = "Hello World again".split(" ");
		printText(splitStrings);
		
		System.out.println("-".repeat(20));
		printText("Hello");
		
		String[] sArray = {"first", "second", "third", "fourth", "fifth"};
		System.out.println(String.join(",", sArray));
		
	}
	
	private static void printText(String... textList) {
		for(String t: textList) {
			System.out.println(t);
		}
	}
}
