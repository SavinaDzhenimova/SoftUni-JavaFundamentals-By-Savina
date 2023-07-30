package MidExam1;

import java.util.Scanner;

public class p01_SoftUniReception {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstWorker = Integer.parseInt(scanner.nextLine());
        int secondWorker = Integer.parseInt(scanner.nextLine());
        int thirdWorker = Integer.parseInt(scanner.nextLine());
        int studentsCount = Integer.parseInt(scanner.nextLine());

        int neededTime = 0;
        int studentsPerHour = firstWorker + secondWorker + thirdWorker;
        while (studentsCount > 0) {
            neededTime++;
            if (neededTime % 4 == 0) {
                neededTime++;
            }
            studentsCount -= studentsPerHour;
        }

        System.out.printf("Time needed: %dh.", neededTime);
    }
}