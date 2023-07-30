package Exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class p05_BombNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbersList = Arrays.stream(scanner.nextLine().split(" "))
                        .map(Integer::parseInt).collect(Collectors.toList());
        String[] commands = scanner.nextLine().split(" ");
        int bombNumber = Integer.parseInt(commands[0]);
        int power = Integer.parseInt(commands[1]);

        while (numbersList.contains(bombNumber)) {
            int bombIndex = numbersList.indexOf(bombNumber);

            if (bombIndex - power >= 0 && bombIndex + power < numbersList.size()) {
                numbersList.subList(bombIndex - power, bombIndex + power + 1).clear();
            } else if (bombIndex - power < 0) {
                numbersList.subList(0, bombIndex + power + 1).clear();
            } else if (bombIndex + power >= numbersList.size()) {
                numbersList.subList(bombIndex - power, numbersList.size()).clear();
            }
        }

        int sum = 0;
        for (int item : numbersList) {
            sum += item;
        }
        System.out.println(sum);
    }
}