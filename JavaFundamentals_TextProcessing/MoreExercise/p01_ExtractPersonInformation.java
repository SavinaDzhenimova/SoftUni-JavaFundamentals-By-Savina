package MoreExercise;

import java.util.Scanner;

public class p01_ExtractPersonInformation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfLines = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numberOfLines; i++) {
            String input = scanner.nextLine();

            int startIndexName = input.indexOf('@');
            int endIndexName = input.indexOf('|');
            String name = input.substring(startIndexName + 1, endIndexName);

            int startIndexAge = input.indexOf('#');
            int endIndexAge = input.indexOf('*');
            int age = Integer.parseInt(input.substring(startIndexAge + 1, endIndexAge));

            System.out.printf("%s is %d years old.%n", name, age);
        }
    }
}