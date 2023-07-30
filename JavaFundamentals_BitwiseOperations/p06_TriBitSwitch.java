import java.util.Scanner;

public class p06_TriBitSwitch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        int position = Integer.parseInt(scanner.nextLine());

        int mask = 7 << position;
        int result = number ^ mask;
        System.out.println(result);
    }
}