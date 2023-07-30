package MoreExercise;

import java.util.Scanner;

public class p05_HTML {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String title = scanner.nextLine();
        String content = scanner.nextLine();
        String comments = scanner.nextLine();

        System.out.println("<h1>");
        System.out.printf("    %s%n", title);
        System.out.println("</h1>");

        System.out.println("<article>");
        System.out.printf("    %s%n", content);
        System.out.println("</article>");

        while (!comments.equals("end of comments")) {
            System.out.println("<div>");
            System.out.printf("    %s%n", comments);
            System.out.println("</div>");

            comments = scanner.nextLine();
        }
    }
}