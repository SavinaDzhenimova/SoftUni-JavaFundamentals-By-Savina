package Lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class p02_GaussTrick {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbersList = Arrays.stream(scanner.nextLine().split(" "))
                        .map(Integer::parseInt).collect(Collectors.toList());

        int size = numbersList.size() / 2;
        for (int i = 0; i < size; i++) {
            int firstElement = numbersList.get(i);
            int lastElement = numbersList.get(numbersList.size() - 1);
            int sum = firstElement + lastElement;

            numbersList.set(i,sum);
            numbersList.remove(numbersList.size() - 1);
        }

        System.out.println(numbersList.toString().replaceAll("[\\[\\],]", ""));
    }
}