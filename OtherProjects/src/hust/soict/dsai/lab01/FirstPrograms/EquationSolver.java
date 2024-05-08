package hust.soict.dsai.lab01.FirstPrograms;

import java.util.Scanner;

public class EquationSolver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose the type of equation to solve:");
        System.out.println("1. First-degree equation (linear equation) with one variable");
        System.out.println("2. System of first-degree equations (linear system) with two variables");
        System.out.println("3. Second-degree equation (quadratic equation) with one variable");
        System.out.print("Enter your choice (1, 2, or 3): ");

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                solveLinearEquation(scanner);
                break;
            case 2:
                solveLinearSystem(scanner);
                break;
            case 3:
                solveQuadraticEquation(scanner);
                break;
            default:
                System.out.println("Invalid choice. Please choose 1, 2, or 3.");
        }

        scanner.close();
    }

    static void solveLinearEquation(Scanner scanner) {
        System.out.print("Enter the coefficient 'a' (must be non-zero): ");
        double a = scanner.nextDouble();

        if (a == 0) {
            System.out.println("Invalid input. 'a' must be non-zero for a first-degree equation.");
            return;
        }

        System.out.print("Enter the coefficient 'b': ");
        double b = scanner.nextDouble();

        double x = -b / a;
        System.out.println("Solution for the first-degree equation: x = " + x);
    }

    static void solveLinearSystem(Scanner scanner) {
        System.out.print("Enter the coefficient 'a11': ");
        double a11 = scanner.nextDouble();

        System.out.print("Enter the coefficient 'a12': ");
        double a12 = scanner.nextDouble();

        System.out.print("Enter the right-hand side 'b1': ");
        double b1 = scanner.nextDouble();

        System.out.print("Enter the coefficient 'a21': ");
        double a21 = scanner.nextDouble();

        System.out.print("Enter the coefficient 'a22': ");
        double a22 = scanner.nextDouble();

        System.out.print("Enter the right-hand side 'b2': ");
        double b2 = scanner.nextDouble();

        double determinant = a11 * a22 - a21 * a12;

        if (determinant != 0) {
            double x1 = (a22 * b1 - a12 * b2) / determinant;
            double x2 = (a11 * b2 - a21 * b1) / determinant;
            System.out.println("Solution for the linear system:");
            System.out.println("x1 = " + x1);
            System.out.println("x2 = " + x2);
        } else {
            if ((a11 * b2 - a21 * b1) == 0 && (a12 * b2 - a22 * b1) == 0) {
                System.out.println("Infinite solutions for the linear system.");
            } else {
                System.out.println("No solution for the linear system.");
            }
        }
    }

    static void solveQuadraticEquation(Scanner scanner) {
        System.out.print("Enter the coefficient 'a' (must be non-zero): ");
        double a = scanner.nextDouble();

        if (a == 0) {
            System.out.println("Invalid input. 'a' must be non-zero for a quadratic equation.");
            return;
        }

        System.out.print("Enter the coefficient 'b': ");
        double b = scanner.nextDouble();

        System.out.print("Enter the coefficient 'c': ");
        double c = scanner.nextDouble();

        double discriminant = b * b - 4 * a * c;

        if (discriminant > 0) {
            double root1 = (-b + Math.sqrt(discriminant)) / (2 * a);
            double root2 = (-b - Math.sqrt(discriminant)) / (2 * a);
            System.out.println("Two distinct real roots for the quadratic equation:");
            System.out.println("Root 1 = " + root1);
            System.out.println("Root 2 = " + root2);
        } else if (discriminant == 0) {
            double root = -b / (2 * a);
            System.out.println("One real double root for the quadratic equation: Root = " + root);
        } else {
            System.out.println("No real roots for the quadratic equation.");
        }
    }
}
