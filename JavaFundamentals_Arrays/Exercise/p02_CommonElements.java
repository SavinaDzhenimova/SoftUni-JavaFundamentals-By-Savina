package Exercise;

import java.util.Scanner;

public class p02_CommonElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] firstArr = scanner.nextLine().split(" ");
        String[] secondArr = scanner.nextLine().split(" ");

        for (int i = 0; i < secondArr.length; i++) {
            String currentElement = secondArr[i];

            for (int j = 0; j < firstArr.length; j++) {
                if (currentElement.equals(firstArr[j])) {
                    System.out.print(secondArr[i] + " ");
                }
            }
        }
    }
}