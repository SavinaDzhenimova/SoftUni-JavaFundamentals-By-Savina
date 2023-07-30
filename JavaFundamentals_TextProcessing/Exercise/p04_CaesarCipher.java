package Exercise;

import java.util.Scanner;

public class p04_CaesarCipher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String message = scanner.nextLine();
        StringBuilder decryptedMessage = new StringBuilder();

        for (int i = 0; i < message.length(); i++) {
            char symbol = message.charAt(i);
            symbol += 3;
            decryptedMessage.append(symbol);
        }

        System.out.println(decryptedMessage);
    }
}