package Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class p09_ArrayModifier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbersArr = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        String input = scanner.nextLine();
        int index1 = 0;
        int index2 = 0;

        while (!input.equals("end")) {
            String[] commands = input.split(" ");

            switch (commands[0]) {
                case "swap":
                    index1 = Integer.parseInt(commands[1]);
                    index2 = Integer.parseInt(commands[2]);

                    int oldElement = numbersArr[index1];
                    numbersArr[index1] = numbersArr[index2];
                    numbersArr[index2] = oldElement;
                    break;
                case "multiply":
                    index1 = Integer.parseInt(commands[1]);
                    index2 = Integer.parseInt(commands[2]);

                    int product = numbersArr[index1] * numbersArr[index2];
                    numbersArr[index1] = product;
                    break;
                case "decrease":
                    for (int i = 0; i < numbersArr.length; i++) {
                        numbersArr[i]--;
                    }
                    break;
            }

            input = scanner.nextLine();
        }

        for (int i = 0; i < numbersArr.length; i++) {
            if (i != numbersArr.length - 1) {
                System.out.print(numbersArr[i] + ", ");
            } else {
                System.out.print(numbersArr[i]);
            }
        }
    }
}