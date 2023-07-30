package Lab;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

public class p01_RandomizeWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> wordsList = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());

        Random rnd = new Random();
        int initialSize = wordsList.size();
        for (int i = 0; i < initialSize; i++) {
            int rndIndex = rnd.nextInt(wordsList.size());
            String randomWord = wordsList.get(rndIndex);

            System.out.println(randomWord);
            wordsList.remove(String.valueOf(randomWord));
        }
    }
}