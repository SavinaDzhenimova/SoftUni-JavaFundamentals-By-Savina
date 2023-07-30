package MidExam5;

import java.util.Scanner;

public class p01_BonusScoringSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int studentsCount = Integer.parseInt(scanner.nextLine());
        int lecturesCount = Integer.parseInt(scanner.nextLine());
        int additionalBonus = Integer.parseInt(scanner.nextLine());

        double maxScore = 0;
        int attendedLectures = 0;
        for (int i = 0; i < studentsCount; i++) {
            int studentAttendance = Integer.parseInt(scanner.nextLine());
            double studentTotalBonus = studentAttendance * 1.00 / lecturesCount * (5 + additionalBonus);

            if (studentTotalBonus > maxScore) {
                maxScore = studentTotalBonus;
                attendedLectures = studentAttendance;
            }
        }

        System.out.printf("Max Bonus: %.0f.%n", Math.ceil(maxScore));
        System.out.printf("The student has attended %d lectures.", attendedLectures);
    }
}