package array.challenge2;

import java.util.Arrays;
import java.util.Scanner;

public class ReverseArray {

	
	public static void main(String args[]) {
		
		
		int[] returnedArray =readIntegers();
		System.out.println(Arrays.toString(returnedArray));
		
		// reverse(returnedArray);
		// System.out.println("Final "+Arrays.toString(returnedArray));
		
		
		//System.out.println("--".repeat(15));
		
		int[] reversedCopy = reverseCopy(returnedArray);
		System.out.println("After reverse " +Arrays.toString(returnedArray));
		System.out.println("reversedCopy " +Arrays.toString(reversedCopy));
		
		
	}
	public static int[] readIntegers() {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a list of integers, separated by commas: ");
		String input = scanner.nextLine();
		
		String[] splits = input.split(",");
		int[] values = new int[splits.length];
		
		for(int i = 0; i < splits.length; i++) {
			values[i] = Integer.parseInt(splits[i].trim());
		}
		
		return values;
	}
	
	private static int findMin(int[] array) {
		
		int min = Integer.MAX_VALUE;
		
		for(int el : array) {
			if(el < min) {
				min = el;
			}
		}		
		
		return min;
	}
	
	private static void reverse(int[] array) {
		int maxIndex = array.length - 1; // minus the current array
		int halfLength = array.length / 2; // cuts the length of the array in half
		
		
		// This will loop through the entire array
		// which was cut in half using halfLength variable
		for(int i = 0; i < halfLength; i++) {
			int temp = array[i];    // watch where the array is 
			array[i] = array[maxIndex - i]; // swaps the number of the current array
			array[maxIndex - i] = temp;  // place the array with the i variable
			
			System.out.println("---->"+ Arrays.toString(array));
		}
		
	}
	
	private static int[] reverseCopy(int[] array) {
		int[] reversedArray = new int[array.length];
		int maxIndex = array.length - 1;
		for(int el : array) {
			reversedArray[maxIndex--] = el;
		}
		
		return reversedArray;
	}
}
