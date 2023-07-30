package AdditionalMidExamExercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class p03_SantaSecretHelper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int key = Integer.parseInt(scanner.nextLine());
        String message = scanner.nextLine();
        String regex = "@(?<name>[A-Za-z]+)[^@\\-!:\\>]+!(?<behaviour>[G|N])!";
        Pattern pattern = Pattern.compile(regex);

        List<String> goodChildrenList = new ArrayList<>();
        while (!message.equals("end")) {
            StringBuilder decodedMessage = new StringBuilder();

            for (int i = 0; i < message.length(); i++) {
                char currentLetter = message.charAt(i);
                char newLetter = (char) (currentLetter - key);
                decodedMessage.append(newLetter);
            }

            Matcher matcher = pattern.matcher(decodedMessage);
            if (matcher.find()) {
                String childName = matcher.group("name");
                String behaviour = matcher.group("behaviour");

                if (behaviour.equals("G")) {
                    goodChildrenList.add(childName);
                }
            }

            message = scanner.nextLine();
        }

        for (String child : goodChildrenList) {
            System.out.println(child);
        }
    }
}