package hust.soict.dsai.lab01.Exercises;

import java.util.Arrays;
import java.util.Scanner;

public class ArraySortingAndStatistics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();

        System.out.println("Enter the elements of the array:");
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            System.out.print("Enter element at index " + i + ": ");
            array[i] = scanner.nextInt();
        }

        Arrays.sort(array);

        System.out.println("Sorted Array: " + Arrays.toString(array));
        System.out.println("Sum of Array Elements: " + calculateSum(array));
        System.out.println("Average of Array Elements: " + calculateAverage(array));

        scanner.close();
    }

    static int calculateSum(int[] array) {
        int sum = 0;
        for (int element : array) {
            sum += element;
        }
        return sum;
    }

    static double calculateAverage(int[] array) {
        if (array.length == 0) {
            return 0.0; // To avoid division by zero
        }

        int sum = calculateSum(array);
        return (double) sum / array.length;
    }
}
