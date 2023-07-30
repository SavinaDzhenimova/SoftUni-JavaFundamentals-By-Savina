package MidExam3;

import java.util.Arrays;
import java.util.Scanner;

public class p02_ShootForTheWin {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] targetLine = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        String command = scanner.nextLine();
        int shotTargets = 0;

        while (!command.equals("End")) {
            int targetIndex = Integer.parseInt(command);

            if (targetIndex >= 0 && targetIndex < targetLine.length) {
                int targetValue = targetLine[targetIndex];
                targetLine[targetIndex] = -1;
                shotTargets++;

                for (int i = 0; i < targetLine.length; i++) {
                    int currentTarget = targetLine[i];

                    if (currentTarget != -1 && currentTarget != targetLine[targetIndex]) {
                        if (currentTarget > targetValue) {
                            currentTarget -= targetValue;
                        } else {
                            currentTarget += targetValue;
                        }
                        targetLine[i] = currentTarget;
                    }
                }
            }

            command = scanner.nextLine();
        }

        System.out.printf("Shot targets: %d -> ", shotTargets);
        for (int item : targetLine) {
            System.out.print(item + " ");
        }
    }
}