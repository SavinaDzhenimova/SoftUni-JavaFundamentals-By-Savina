package MidExam3;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class p03_MovingTarget {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> targetsLine = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        String input = scanner.nextLine();

        while (!input.equals("End")) {
            String[] commands = input.split(" ");
            int index = Integer.parseInt(commands[1]);

            switch (commands[0]) {
                case "Shoot":
                    int power = Integer.parseInt(commands[2]);

                    if (index >= 0 && index < targetsLine.size()) {
                        int targetValue = targetsLine.get(index);
                        targetValue -= power;

                        if (targetValue <= 0) {
                            targetsLine.remove(index);
                        } else {
                            targetsLine.set(index, targetValue);
                        }
                    }
                    break;
                case "Add":
                    int value = Integer.parseInt(commands[2]);

                    if (index >= 0 && index < targetsLine.size()) {
                        targetsLine.add(index, value);
                    } else {
                        System.out.println("Invalid placement!");
                    }
                    break;
                case "Strike":
                    int radius = Integer.parseInt(commands[2]);

                    if (index - radius >= 0 && index + radius < targetsLine.size() - 1) {
                        for (int i = 0; i < radius * 2 + 1; i++) {
                            targetsLine.remove(index - radius);
                        }
                    } else {
                        System.out.println("Strike missed!");
                        break;
                    }
                    break;
            }

            input = scanner.nextLine();
        }

        for (int i = 0; i < targetsLine.size(); i++) {
            int item = targetsLine.get(i);

            if (i == targetsLine.size() - 1) {
                System.out.print(item + "");
            } else {
                System.out.print(item + "|");
            }
        }
    }
}