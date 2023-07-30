package Lab;

import java.util.*;
import java.util.stream.Collectors;

public class p01_CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbersList = Arrays.stream(scanner.nextLine().split(" "))
                        .map(Integer::parseInt).collect(Collectors.toList());
        TreeMap<Integer, Integer> numbersCountMap = new TreeMap<>();

        for (int i = 0; i < numbersList.size(); i++) {
            int currentNum = numbersList.get(i);

            if (!numbersCountMap.containsKey(currentNum)) {
                numbersCountMap.put(currentNum, 0);
            }
            numbersCountMap.put(currentNum, numbersCountMap.get(currentNum) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : numbersCountMap.entrySet()) {
            System.out.printf("%d -> %d%n", entry.getKey(), entry.getValue());
        }
    }
}