package Exercise;

import java.util.Scanner;

public class p04_PasswordValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String password = scanner.nextLine();

        if (isBetweenSixAndTenCharacters(password) && consistOnlyOfLettersAndDigits(password) && haveAtLeastTwoDigits(password)) {
            System.out.println("Password is valid");
        }
        if (!isBetweenSixAndTenCharacters(password)) {
            System.out.println("Password must be between 6 and 10 characters");
        }
        if (!consistOnlyOfLettersAndDigits(password)) {
            System.out.println("Password must consist only of letters and digits");
        }
        if (!haveAtLeastTwoDigits(password)) {
            System.out.println("Password must have at least 2 digits");
        }
    }

    public static boolean isBetweenSixAndTenCharacters(String password) {
        if (password.length() >= 6 && password.length() <= 10) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean consistOnlyOfLettersAndDigits(String password) {
        for (int i = 0; i < password.length(); i++) {
            char symbol = password.charAt(i);

            if ((symbol >= 1 && symbol <= 47) || (symbol >= 58 && symbol <= 64) || (symbol >= 91 && symbol <= 96)
                || symbol >= 123) {
                return false;
            }
        }
        return true;
    }

    public static boolean haveAtLeastTwoDigits(String password) {
        int digitsCounter = 0;
        for (int i = 0; i < password.length(); i++) {
            char symbol = password.charAt(i);

            if (symbol >= '0' && symbol <= '9') {
                digitsCounter++;
            }
        }

        if (digitsCounter >= 2) {
            return true;
        } else {
            return false;
        }
    }
}