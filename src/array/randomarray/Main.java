package array.randomarray;

import java.util.*;

public class Main {
	
	public static void main(String args[]) {
		int[] firstArray = getRandomArray(10);
		System.out.println(Arrays.toString(firstArray));
		Arrays.sort(firstArray);
		System.out.println(Arrays.toString(firstArray));
		
		int[] secondArray = new int[10];
		Arrays.fill(secondArray, 5);
		System.out.println(Arrays.toString(secondArray));
		
		
		int[] thirdArray = getRandomArray(10);
		System.out.println(Arrays.toString(thirdArray));
		
		int[] fourthArray =Arrays.copyOf(thirdArray, thirdArray.length);
		System.out.println(Arrays.toString(fourthArray));
		
		Arrays.sort(fourthArray);
		System.out.println(Arrays.toString(thirdArray));
		System.out.println(Arrays.toString(fourthArray));
	}

	private static int[] getRandomArray(int len) {
		
		Random random = new Random();  // call to generate random numbers
		int[] randomNum = new int[len]; // Will use this to pass the random Object in the for loop 
		
		// For loop is create to generate random number
		
		for(int i = 0; i < len; i++) {      // created for loop to get the len for the array
			randomNum[i] = random.nextInt(100);  // generates random number using the len in the getRandomArray() function 
		}
		
		return randomNum; // returns random number that got generated
		
	}
}
