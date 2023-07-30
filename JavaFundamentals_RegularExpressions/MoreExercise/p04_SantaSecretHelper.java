package MoreExercise;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class p04_SantaSecretHelper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int key = Integer.parseInt(scanner.nextLine());
        String decryptedMessage = scanner.nextLine();
        String regex = "@(?<name>[A-Za-z]+)([^@\\-!:>])*?!(?<behaviour>[G|N])!";
        Pattern pattern = Pattern.compile(regex);

        while (!decryptedMessage.equals("end")) {
            StringBuilder encryptedMessage = new StringBuilder();

            for (int i = 0; i < decryptedMessage.length(); i++) {
                char currentChar = decryptedMessage.charAt(i);
                currentChar -= key;

                encryptedMessage.append(currentChar);
            }

            Matcher matcher = pattern.matcher(encryptedMessage);

            while (matcher.find()) {
                String name = matcher.group("name");
                String behaviour = matcher.group("behaviour");

                if (behaviour.equals("G")) {
                    System.out.println(name);
                }
            }

            decryptedMessage = scanner.nextLine();
        }
    }
}