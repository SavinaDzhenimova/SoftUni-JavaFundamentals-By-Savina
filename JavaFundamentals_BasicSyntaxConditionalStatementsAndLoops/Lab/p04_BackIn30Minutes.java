package Lab;

import java.util.Scanner;

public class p04_BackIn30Minutes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int hours = Integer.parseInt(scanner.nextLine());
        int minutes = Integer.parseInt(scanner.nextLine());

        int timeAfter30Minutes = hours * 60 + minutes + 30;
        int totalHours = timeAfter30Minutes / 60;
        int totalMinutes = timeAfter30Minutes % 60;

        if (totalHours == 24) {
            totalHours = 0;
        }

        System.out.printf("%d:%02d", totalHours, totalMinutes);
    }
}