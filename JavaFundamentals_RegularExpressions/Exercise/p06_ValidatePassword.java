package Exercise;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class p06_ValidatePassword {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countOfPasswords = Integer.parseInt(scanner.nextLine());
        String regex = "_\\.+(?<passwordText>[A-Z][A-Za-z0-9]{4,}[A-Z])_\\.+";
        Pattern pattern = Pattern.compile(regex);

        for (int i = 0; i < countOfPasswords; i++) {
            String password = scanner.nextLine();
            Matcher matcher = pattern.matcher(password);

            if (matcher.find()) {
                String currentPassword = matcher.group("passwordText");

                StringBuilder group = new StringBuilder();
                boolean hasDigit = false;
                for (int j = 0; j < currentPassword.length(); j++) {
                    char currentChar = currentPassword.charAt(j);

                    if (Character.isDigit(currentChar)) {
                        group.append(currentChar);
                        hasDigit = true;
                    }
                }

                if (!hasDigit) {
                    group = new StringBuilder("default");
                }

                System.out.println("Group: " + group);
            } else {
                System.out.println("Invalid pass!");
            }
        }
    }
}