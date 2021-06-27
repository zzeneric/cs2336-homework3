// Raghav Pillai, 6/24/21

import java.util.Scanner;

public class checkSorting {
	public static boolean isSorted(int[] list){ // Check if list is sorted
		for (int i = 0; i < list.length - 1; i++){ // Go through list
			if (list[i] > list[i + 1]){ // If new item is bigger than next item
                return false;
            }
		}
		return true; // If sorted
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in); // Input for input
        
		System.out.print("Enter list: "); // Prompt input
        int[] list = new int[input.nextInt()]; // Get first number and allocate array based on this integer

		for (int i = 0; i < list.length; i++){ // Get the next numbers
            list[i] = input.nextInt(); // Add input to list
        }
        input.close(); // Close the scanner for memory leaks
        
        if(isSorted(list)){ // If sorted
            System.out.println("The list is already sorted");
        }else{
            System.out.println("The list is not sorted");
        }
	}
}