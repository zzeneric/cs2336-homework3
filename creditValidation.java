import java.util.Scanner;

public class creditValidation {   
    public void getInput(){
        
    }

    /** Return true if the card number is valid */
    public static boolean isValid(long number){

        boolean valid =
			(getSize(number) >= 13 && getSize(number) <= 16) &&
			(prefixMatched(number, 4) || prefixMatched(number, 5) ||
			prefixMatched(number, 37) || prefixMatched(number, 6)) &&
			((sumOfDoubleEvenPlace(number) + sumOfOddPlace(number)) % 10 == 0);

		return valid;
    }
    /** Get the result from Step 2 */
    public static int sumOfDoubleEvenPlace(long number){
        String s = Long.toString(number);
        int sum = 0;

        for(int i = 0; i <= s.length(); i++){
            char ch = s.charAt(i);
            sum += Integer.parseInt(String.valueOf(ch));
        }
        return sum;
    }
    /** Return this number if it is a single digit, otherwise,
    * return the sum of the two digits */
    public static int getDigit(int number){
        if(number > 9){
            number = number/10 + number%10;
        }
        return number;
    }
    /** Return sum of odd-place digits in number */
    public static int sumOfOddPlace(long number){
        String s = Long.toString(number);
        int sum = 0;

        for(int i = 1; i <= s.length(); i+=2){
            char ch = s.charAt(i);
            sum += Integer.parseInt(String.valueOf(ch));
        }
        return sum;
    }
    /** Return true if the digit d is a prefix for number */
    public static boolean prefixMatched(long number, int d){
        return getPrefix(number, getSize(d)) == d;
    }
    /** Return the number of digits in d */
    public static int getSize(long d){
        String s = Long.toString(d);
        return s.length();
    }
    /** Return the first k number of digits from number. If the
    * number of digits in number is less than k, return number. */
    public static long getPrefix(long number, int k){
        if (getSize(number) > k)  {
			String num = Long.toString(number);
			number = Long.parseLong(num.substring(0, k));
		}
		return number;
    }
    
    public static void main(String[] args){
        Scanner input = new Scanner(System.in); // Create a Scanner

		// Prompt the user to enter a credit card number as a long integer
		System.out.print("Enter a credit card number as a long integer: ");
		long number = input.nextLong();

		System.out.println(
			number + " is " + (isValid(number) ? "valid" : "invalid"));
    }
}
