package Exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class p08_AnonymousThreat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> stringsList = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());
        String input = scanner.nextLine();

        while (!input.equals("3:1")) {
            String[] commands = input.split(" ");

            switch (commands[0]) {
                case "merge":
                    int startIndex = Integer.parseInt(commands[1]);
                    int endIndex = Integer.parseInt(commands[2]);

                    if (startIndex < 0) {
                        startIndex = 0;
                    }
                    if (endIndex > stringsList.size() - 1) {
                        endIndex = stringsList.size() - 1;
                    }
                    int counter = startIndex;

                    for (int i = startIndex; i < endIndex; i++) {
                        String concat = stringsList.get(counter) + stringsList.get(counter + 1);
                        stringsList.set(counter, concat);
                        stringsList.remove(counter + 1);
                    }
                    break;
                case "divide":
                    int index = Integer.parseInt(commands[1]);
                    int partitions = Integer.parseInt(commands[2]);
                    if (index >= 0 && index < stringsList.size() && partitions >= 0 && partitions <= 100) {
                        String element = stringsList.get(index);
                        List<String> newList = new ArrayList<>();

                        int portionLength = element.length() / partitions;
                        int count = 0;
                        if (element.length() % partitions == 0) {
                            for (int i = 0; i < partitions; i++) {
                                StringBuilder concat = new StringBuilder();
                                for (int j = 0; j < portionLength; j++) {
                                    char symbol = element.charAt(count);
                                    concat.append(symbol);
                                    count++;
                                }
                                newList.add(String.valueOf(concat));
                            }
                        } else {
                            for (int i = 0; i < partitions; i++) {
                                StringBuilder concat = new StringBuilder();

                                if (i == partitions - 1) {
                                    for (int j = count; j < element.length(); j++) {
                                        char symbol = element.charAt(count);
                                        concat.append(symbol);
                                        count++;
                                    }
                                } else {
                                    for (int j = 0; j < portionLength; j++) {
                                        char symbol = element.charAt(count);
                                        concat.append(symbol);
                                        count++;
                                    }
                                }
                                newList.add(String.valueOf(concat));
                            }
                        }
                        stringsList.remove(index);
                        stringsList.addAll(index, newList);
                    }
                    break;
            }

            input = scanner.nextLine();
        }

        System.out.println(stringsList.toString().replaceAll("[\\[\\],]", ""));
    }
}