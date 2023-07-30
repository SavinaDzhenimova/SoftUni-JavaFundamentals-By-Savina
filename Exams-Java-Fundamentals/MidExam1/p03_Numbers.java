package MidExam1;

import java.util.*;
import java.util.stream.Collectors;

public class p03_Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        int sum = 0;
        for (Integer number : numbers) {
            sum += number;
        }

        double averageNum = sum * 1.00 / numbers.size();
        List<Integer> newList = new ArrayList<>();
        for (Integer number : numbers) {
            if (number > averageNum) {
                newList.add(number);
            }
        }

        Collections.sort(newList);
        Collections.reverse(newList);

        if (newList.isEmpty()) {
            System.out.println("No");
        } else {
            if (newList.size() > 5) {
                for (int i = 0; i < 5; i++) {
                    System.out.print(newList.get(i) + " ");
                }
            } else {
                for (int item : newList) {
                    System.out.print(item + " ");
                }
            }
        }
    }
}