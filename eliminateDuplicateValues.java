// Raghav Pillai, 6/24/21

import java.util.Scanner; // import Scanner for input

public class eliminateDuplicateValues{
    public static int[] eliminateDuplicates(int[] list){
        int[] newList = new int[list.length]; // New list to hold non duplicate numbers
        for(int i = 0; i < list.length; i++){ // Loop through list
            if (checkValues(newList, list[i])){ // Check values to see if it already is put in table
                newList[i] = list[i]; // Assign if not
            }
        }
		return newList; // Return array
    }

    public static int[] getInput(){
        Scanner input = new Scanner(System.in); // Input
        int[] numbers = new int[10]; // New int array
        System.out.print("Enter ten numbers: ");

        for (int i = 0; i < numbers.length; i++){ // 10 number loop
            numbers[i] = input.nextInt(); // Get next number for each input
        }
        input.close(); // Close scanner to remove 
        return numbers; // Return the int table
    }

    public static boolean checkValues(int[] numbers, int toFind){ // Find if the value already exists in numbers
		for (int i = 0; i < numbers.length; i++) { // Loop through existing values
			if (toFind == numbers[i]){ // If found
                return false;
            }
		}
		return true; // Doesn't exist yet
	}

    public static void main(String[] args){
        int[] numbers = getInput(); // Get all inputs and cast to int array

        int[] distinctNumbers = eliminateDuplicates(numbers);

		// Display the result
		System.out.print("The distinct numbers are:");
        for(int i = 0; i < distinctNumbers.length; i++){
            if (distinctNumbers[i] > 0){
                System.out.print(" " + distinctNumbers[i]);
            }
        }
		System.out.println();
    }
}