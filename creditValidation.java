// Raghav Pillai, 6/24/21

import java.util.Scanner; // import Scanner for input

public class creditValidation{   
    public static long getInput(){
        Scanner input = new Scanner(System.in); // Create a Scanner

		// Prompt the user to enter a credit card number as a long integer
		System.out.print("Enter a credit card number as a long integer: ");

		long number = input.nextLong(); // Get next number from input
        input.close(); // Close input to remove memory leak

        return number;
    }

    public static boolean isValid(long number){ // Return true if the card number is valid
        boolean valid =
			(getSize(number) >= 13 && getSize(number) <= 16) && // Size between 13-16
			(prefixMatched(number, 4) || prefixMatched(number, 5) || prefixMatched(number, 37) || prefixMatched(number, 6)) && // visa, master, amex, discover prefixes
			((sumOfDoubleEvenPlace(number) + sumOfOddPlace(number)) % 10 == 0); // Make sure that the last step is divisible by 10

		return valid;
    }

    public static int sumOfDoubleEvenPlace(long number){ // Get the result from Step 2
        String s = Long.toString(number); // Get a string to get digit at char
        int sum = 0;

        for(int i = getSize(number) - 2; i >= 0; i -= 2){ // Loop backwards to find even place digits
            char ch = s.charAt(i); // Get digit at place
            sum += getDigit(Integer.parseInt(String.valueOf(ch)) * 2); // Multiply by 2
        }
        return sum;
    }

    public static int getDigit(int number){ // Return this number if it is a single digit, otherwise, return the sum of the two digits
        if(number > 9){ // If number is over 2 digits, or else just return the number
            number = number/10 + number%10; // First digit (num/10) + second digit (num%10)
        }
        return number;
    }

    public static int sumOfOddPlace(long number){ // Return sum of odd-place digits in number
        String s = Long.toString(number); // Get a string to get digit at char
        int sum = 0;

        for(int i = getSize(number) - 1; i >= 0; i -= 2){ // Loop backwards to find odd place digits
            char ch = s.charAt(i); // Get digit at place
            sum += Integer.parseInt(String.valueOf(ch)); // Add to sum
        }
        return sum;
    }
    public static boolean prefixMatched(long number, int d){ // Return true if the digit d is a prefix for number
        return getPrefix(number, getSize(d)) == d;
    }
    public static int getSize(long d){ // Return the number of digits in d
        String s = Long.toString(d);
        return s.length();
    }

    public static long getPrefix(long number, int k){ // Return the first k number of digits from number. If the number of digits in number is less than k, return number.
        if (getSize(number) > k){  // Get the first k number of digits here
			String num = Long.toString(number);
            number = Long.parseLong(num.substring(0, k));
		}
		return number;
    }
    
    public static void main(String[] args){
        long number = getInput(); // Get long from input

		System.out.print(number + " is "); // Get the number 
        if(isValid(number)){ // Print either valid or invalid
            System.out.print("valid");
        }else{
            System.out.print("invalid");
        }
    }
}
