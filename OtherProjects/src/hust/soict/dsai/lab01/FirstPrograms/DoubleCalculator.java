package hust.soict.dsai.lab01.FirstPrograms;

import java.util.Scanner;

public class DoubleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get the first double number from the user
        System.out.print("Enter the first double number: ");
        String strNum1 = scanner.nextLine();
        double num1 = parseDoubleInput(strNum1);

        // Get the second double number from the user
        System.out.print("Enter the second double number: ");
        String strNum2 = scanner.nextLine();
        double num2 = parseDoubleInput(strNum2);

        // Calculate and display the sum, difference, product, and quotient
        double sum = num1 + num2;
        double difference = Math.abs(num1 - num2);
        double product = num1 * num2;

        if (num2 != 0) {
            double quotient = num1 / num2;
            System.out.println("Quotient: " + quotient);
        } else {
            System.out.println("Cannot calculate quotient. Division by zero.");
        }

        System.out.println("Sum: " + sum);
        System.out.println("Difference: " + difference);
        System.out.println("Product: " + product);

        scanner.close();
    }

    static double parseDoubleInput(String input) {
        try {
            return Double.parseDouble(input);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid double number.");
            System.exit(1); // Terminate the program if the input is not a valid double
            return 0; // This line will never be reached
        }
    }
}
