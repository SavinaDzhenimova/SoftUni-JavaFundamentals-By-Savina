package MoreExercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class p04_MorseCodeTranslator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> morseCode = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());
        StringBuilder text = new StringBuilder();

        for (String currentLetter : morseCode) {
            switch (currentLetter) {
                case ".-":
                    text.append('A');
                    break;
                case "-...":
                    text.append('B');
                    break;
                case "-.-.":
                    text.append('C');
                    break;
                case "-..":
                    text.append('D');
                    break;
                case ".":
                    text.append('E');
                    break;
                case "..-.":
                    text.append('F');
                    break;
                case "--.":
                    text.append('G');
                    break;
                case "....":
                    text.append('H');
                    break;
                case "..":
                    text.append('I');
                    break;
                case ".---":
                    text.append('J');
                    break;
                case "-.-":
                    text.append('K');
                    break;
                case ".-..":
                    text.append('L');
                    break;
                case "--":
                    text.append('M');
                    break;
                case "-.":
                    text.append('N');
                    break;
                case "---":
                    text.append('O');
                    break;
                case ".--.":
                    text.append('P');
                    break;
                case "--.-":
                    text.append('Q');
                    break;
                case ".-.":
                    text.append('R');
                    break;
                case "...":
                    text.append('S');
                    break;
                case "-":
                    text.append('T');
                    break;
                case "..-":
                    text.append('U');
                    break;
                case "...-":
                    text.append('V');
                    break;
                case ".--":
                    text.append('W');
                    break;
                case "-..-":
                    text.append('X');
                    break;
                case "-.--":
                    text.append('Y');
                    break;
                case "--..":
                    text.append('Z');
                    break;
                case "|":
                    text.append(" ");
                    break;
            }
        }

        System.out.println(text);
    }
}