package Lab;

import java.util.Scanner;

public class p02_Grades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double grade = Double.parseDouble(scanner.nextLine());

        printGradeWithWords(grade);
    }

    public static void printGradeWithWords(double grade) {
        String gradeWithWords = "";
        if (grade >= 2.00 && grade <= 2.99) {
            gradeWithWords = "Fail";
        } else if (grade >= 3.00 && grade <= 3.49) {
            gradeWithWords = "Poor";
        } else if (grade >= 3.50 && grade <= 4.49) {
            gradeWithWords = "Good";
        } else if (grade >= 4.50 && grade <= 5.49) {
            gradeWithWords = "Very good";
        } else if (grade >= 5.50 && grade <= 6.00) {
            gradeWithWords = "Excellent";
        }
        System.out.println(gradeWithWords);
    }
}