package Exercise;

import java.util.Scanner;

public class p09_SpiceMustFlow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int startingYield = Integer.parseInt(scanner.nextLine());
        int extractedSpice = 0;
        int days = 0;

        while (startingYield >= 100) {
            days++;
            extractedSpice += startingYield - 26;
            startingYield -= 10;
        }
        if (extractedSpice >= 26)
        {
            extractedSpice -= 26;
        }

        System.out.println(days);
        System.out.println(extractedSpice);
    }
}