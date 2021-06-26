// Raghav Pillai, 6/24/21

import java.util.Scanner; // import Scanner for input

public class computeDeviation{
    public static double deviation(double[] x){ // Compute the deviation of double values
        double deviation = 0;
        double mean = mean(x); // Get mean of array
        for (int i = 0; i < x.length; i++){ // Loop through all values
            double sum = x[i] - mean; // Get the deviation of the value vs mean
            deviation += Math.pow(sum, 2); // Square the deviation
        }
        double dev = Math.sqrt(deviation / (x.length - 1)); // Square root of (deviation over n-1)
        return dev;
    }

    public static double mean(double[] x){ // Compute the mean of an array of double values
        double sum = 0;
        for (int i = 0; i < x.length; i++){ // Length of array
            sum += x[i]; // Add to sum
        }
        double div = sum/x.length; // Get sum/#numbers
        return div; // Return mean
    }
    
    public static double[] getInput(){
        Scanner input = new Scanner(System.in); // Input
        double[] numbers = new double[10]; // New double array
        System.out.print("Enter ten numbers: ");

        for (int i = 0; i < numbers.length; i++){ // 10 number loop
            numbers[i] = input.nextDouble(); // Get next number for each input
        }
        input.close(); // Close scanner to remove 
        return numbers; // Return the double table
    }

    public static void main(String[] args){
        double[] numbers = getInput(); // Get all inputs and cast to double array

        System.out.println("The mean is: " + mean(numbers)); // Print mean
        System.out.println("The standard deviation is: " + deviation(numbers)); // Get and print deviation
    }
}