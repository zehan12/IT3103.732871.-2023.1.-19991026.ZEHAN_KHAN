package hust.soict.dsai.lab01.Exercises;

import java.util.Scanner;

public class StarTriangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the height of the triangle: ");
        int n = scanner.nextInt();
        displayTriangle(n);

        scanner.close();
    }

    static void displayTriangle(int height) {
        for (int i = 1; i <= height; i++) {
            for (int j = 0; j < height - i; j++)
                System.out.print(" ");
            for (int j = 0; j < 2 * i - 1; j++)
                System.out.print("*");
            System.out.println();
        }
    }
}
