package hust.soict.dsai.lab01.Exercises;

import java.util.Scanner;

public class MatrixAddition {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get the dimensions of the matrices
        System.out.print("Enter the number of rows: ");
        int rows = scanner.nextInt();

        System.out.print("Enter the number of columns: ");
        int columns = scanner.nextInt();

        // Input matrices
        System.out.println("Enter elements of the first matrix:");
        int[][] matrix1 = inputMatrix(rows, columns, scanner);

        System.out.println("Enter elements of the second matrix:");
        int[][] matrix2 = inputMatrix(rows, columns, scanner);

        // Add matrices
        int[][] resultMatrix = addMatrices(matrix1, matrix2);

        // Display the result
        System.out.println("Resultant Matrix after addition:");
        displayMatrix(resultMatrix);

        scanner.close();
    }

    static int[][] inputMatrix(int rows, int columns, Scanner scanner) {
        int[][] matrix = new int[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print("Enter element at position (" + (i + 1) + ", " + (j + 1) + "): ");
                matrix[i][j] = scanner.nextInt();
            }
        }

        return matrix;
    }

    static int[][] addMatrices(int[][] matrix1, int[][] matrix2) {
        int rows = matrix1.length;
        int columns = matrix1[0].length;

        int[][] resultMatrix = new int[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                resultMatrix[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }

        return resultMatrix;
    }

    static void displayMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
}
