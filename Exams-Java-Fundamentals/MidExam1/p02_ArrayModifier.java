package MidExam1;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class p02_ArrayModifier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                        .map(Integer::parseInt).collect(Collectors.toList());
        String input = scanner.nextLine();

        while (!input.equals("end")) {
            List<String> commands = Arrays.stream(input.split(" ")).collect(Collectors.toList());

            int index1;
            int index2;
            switch (commands.get(0)) {
                case "swap":
                    index1 = Integer.parseInt(commands.get(1));
                    index2 = Integer.parseInt(commands.get(2));

                    swap(numbers, index1, index2);
                    break;
                case "multiply":
                    index1 = Integer.parseInt(commands.get(1));
                    index2 = Integer.parseInt(commands.get(2));

                    multiply(numbers, index1, index2);
                    break;
                case "decrease":
                    decrease(numbers);
                    break;
            }

            input = scanner.nextLine();
        }

        for (int i = 0; i < numbers.size(); i++) {
            if (i == numbers.size() - 1) {
                System.out.print(numbers.get(i));
            } else {
                System.out.print(numbers.get(i) + ", ");
            }
        }
    }

    public static void swap(List<Integer> numbers, int index1, int index2) {
        int firstNum = numbers.get(index1);
        int secondNum = numbers.get(index2);

        numbers.set(index2, firstNum);
        numbers.set(index1, secondNum);
    }

    public static void multiply(List<Integer> numbers, int index1, int index2) {
        int product = numbers.get(index1) * numbers.get(index2);
        numbers.set(index1, product);
    }

    public static void decrease(List<Integer> numbers) {
        numbers.replaceAll(integer -> integer - 1);
    }
}