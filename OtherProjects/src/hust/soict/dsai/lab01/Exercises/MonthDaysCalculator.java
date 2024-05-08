package hust.soict.dsai.lab01.Exercises;

import java.util.Scanner;

public class MonthDaysCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get month input from the user
        String monthInput;
        int month;

        do {
            System.out.print("Enter the month (full name, abbreviation, or number): ");
            monthInput = scanner.nextLine().toLowerCase();
            month = getMonthFromInput(monthInput);
        } while (month == -1);

        // Get year input from the user
        int year;
        do {
            System.out.print("Enter the year (non-negative, all digits): ");
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a valid year.");
                scanner.next();
            }
            year = scanner.nextInt();
            scanner.nextLine();
        } while (year < 0);

        // Check if it's a leap year
        boolean isLeapYear = isLeapYear(year);
        int daysInMonth = getDaysInMonth(month, isLeapYear);
        System.out.println("Number of days in " + monthInput + " " + year + ": " + daysInMonth);
        scanner.close();
    }

    static int getMonthFromInput(String input) {
        return switch (input) {
            case "january", "jan.", "jan", "1" -> 1;
            case "february", "feb.", "feb", "2" -> 2;
            case "march", "mar.", "mar", "3" -> 3;
            case "april", "apr.", "apr", "4" -> 4;
            case "may", "5" -> 5;
            case "june", "jun.", "jun", "6" -> 6;
            case "july", "jul.", "jul", "7" -> 7;
            case "august", "aug.", "aug", "8" -> 8;
            case "september", "sep.", "sep", "9" -> 9;
            case "october", "oct.", "oct", "10" -> 10;
            case "november", "nov.", "nov", "11" -> 11;
            case "december", "dec.", "dec", "12" -> 12;
            default -> {
                System.out.println("Invalid month input. Please enter a valid month.");
                yield -1;
            }
        };
    }

    static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    static int getDaysInMonth(int month, boolean isLeapYear) {
        return switch (month) {
            // January, March, May, July, August, October, December
            case 1, 3, 5, 7, 8, 10, 12 -> 31;
            // April, June, September, November
            case 4, 6, 9, 11 -> 30;
            // February
            case 2 -> isLeapYear ? 29 : 28;
            // Invalid month
            default -> -1;
        };
    }
}
