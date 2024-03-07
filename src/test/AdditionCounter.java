package test;

import java.util.Scanner;

public class AdditionCounter {

	public static void main(String args[]) {
		
		Scanner input = new Scanner(System.in);
		int number = input.nextInt();
		int counter = 0;
		int sum = 0;
		while(number != 0) {
			System.out.println("Please continue to enter a number that is not zero: ");
			sum += number;
			counter++;
			number = input.nextInt();

			if(number == 0) {
				break;
			}
			
		}
		
		System.out.println("The total number that was added: "+sum);
		
	}
}

