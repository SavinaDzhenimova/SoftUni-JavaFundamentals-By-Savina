package Exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class p02_ChangeList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Delete {element} - delete all elements in the array which are equal to the given element
        //Insert {element} {position} - insert element at the given position

        List<Integer> numbersList = Arrays.stream(scanner.nextLine().split(" "))
                        .map(Integer::parseInt).collect(Collectors.toList());
        String input = scanner.nextLine();

        while (!input.equals("end")) {
            String[] commands = input.split(" ");
            int element = Integer.parseInt(commands[1]);

            switch (commands[0]) {
                case "Delete":
                    numbersList.removeIf(item -> item == element);
                    break;
                case "Insert":
                    int position = Integer.parseInt(commands[2]);
                    numbersList.add(position, element);
                    break;
            }

            input = scanner.nextLine();
        }

        System.out.println(numbersList.toString().replaceAll("[\\[\\],]", ""));
    }
}