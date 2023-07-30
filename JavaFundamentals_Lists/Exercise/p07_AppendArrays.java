package Exercise;

import java.util.*;
import java.util.stream.Collectors;

public class p07_AppendArrays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> input = Arrays.stream(sc.nextLine().split("\\|")).collect(Collectors.toList());

        List<String> output = new ArrayList<>();

        for (int i = input.size() - 1; i >= 0; i--) {
            String[] numbers = input.get(i).split("\\s+");
            for (String item : numbers) {
                if (!item.equals("")) {
                    output.add(item);
                }
            }
        }

        System.out.println(output.toString().replaceAll("[\\[\\],]", ""));
    }
}