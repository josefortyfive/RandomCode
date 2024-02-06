package array.challenge;

import java.util.Arrays;
import java.util.Random;

public class Main {
	
	public static void main(String args[]) {
		
		int[] numberGen = getRandomArray(5);
		
		Arrays.toString(numberGen);
		System.out.println(Arrays.toString(numberGen));
		
		
		
		Arrays.sort(numberGen);
		System.out.println(Arrays.toString(numberGen));
		
		
		//int[] sortedArray = sortInteger(new int[] {7, 10, 85});
		//System.out.println(Arrays.toString(sortedArray));
		
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
	
	private static int[] sortInteger(int[] array ) {
		
		System.out.println(Arrays.toString(array));
		int[] sortedArray = Arrays.copyOf(array, array.length);
		boolean flag = true;
		int temp;
		
		while(flag) {
			flag = false;
			for(int i = 0; i < sortedArray.length - 1; i++) {
				if(sortedArray[i] < sortedArray[i + 1]) { // compare the second element
					temp = sortedArray[i];
					sortedArray[i] = sortedArray[i + 1]; //set current element
					sortedArray[i + 1] = temp; // set the next element;
					flag =true;
					
					System.out.println("------>" + Arrays.toString(sortedArray));
				}
			}
			System.out.println("-->" + Arrays.toString(sortedArray));
		}
		
		return sortedArray;
	}

}
