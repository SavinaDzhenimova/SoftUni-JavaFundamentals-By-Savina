package Exercise;

import java.util.Scanner;

public class p02_Articles {
    public static class Article {
        String title;
        String content;
        String author;

        public Article(String title, String content, String author) {
            this.title = title;
            this.content = content;
            this.author = author;
        }

        public void edit(String newContent) {
           this.content = newContent;
        }

        public void changeAuthor(String newAuthor) {
            this.author = newAuthor;
        }

        public void rename(String newTitle) {
            this.title = newTitle;
        }

        @Override
        public String toString() {
            return this.title + " - " + this.content + ": " + this.author;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] articleData = scanner.nextLine().split(", ");
        String title = articleData[0];
        String content = articleData[1];
        String author = articleData[2];

        Article article = new Article(title, content, author);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] command = scanner.nextLine().split(": ");

            switch (command[0]) {
                case "Edit":
                    String newContent = command[1];
                    article.edit(newContent);
                    break;
                case "ChangeAuthor":
                    String newAuthor = command[1];
                    article.changeAuthor(newAuthor);
                    break;
                case "Rename":
                    String newTitle = command[1];
                    article.rename(newTitle);
                    break;
            }
        }

        System.out.println(article);
    }
}