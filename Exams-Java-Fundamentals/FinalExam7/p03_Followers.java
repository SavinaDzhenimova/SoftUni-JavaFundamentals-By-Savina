package FinalExam7;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class p03_Followers {
    public static class Follower{
        int likes;
        int comments;

        public Follower(int likes, int comments) {
            this.likes = likes;
            this.comments = comments;
        }

        public int getLikes() {
            return this.likes;
        }

        public int getComments() {
            return this.comments;
        }

        public void setLikes(int likes) {
            this.likes = likes;
        }

        public void setComments(int comments) {
            this.comments = comments;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();

        LinkedHashMap<String, Follower> followers = new LinkedHashMap<>();
        while (!command.equals("Log out")) {
            String[] tokens = command.split(":\\s+");
            String username = tokens[1];

            switch (tokens[0]) {
                case "New follower":
                    followers.putIfAbsent(username, new Follower(0, 0));
                    break;
                case "Like":
                    int count = Integer.parseInt(tokens[2]);

                    if (!followers.containsKey(username)) {
                        followers.put(username, new Follower(count, 0));
                    } else {
                        int newLikes = followers.get(username).getLikes() + count;
                        followers.get(username).setLikes(newLikes);
                    }
                    break;
                case "Comment":
                    if (!followers.containsKey(username)) {
                        followers.put(username, new Follower(0, 1));
                    } else {
                        int newComments = followers.get(username).getComments() + 1;
                        followers.get(username).setComments(newComments);
                    }
                    break;
                case "Blocked":
                    if (followers.containsKey(username)) {
                        followers.remove(username);
                    } else {
                        System.out.printf("%s doesn't exist.%n", username);
                    }
                    break;
            }

            command = scanner.nextLine();
        }

        System.out.printf("%d followers%n", followers.size());
        for (Map.Entry<String, Follower> entry : followers.entrySet()) {
            System.out.printf("%s: %d%n", entry.getKey(), entry.getValue().getLikes() + entry.getValue().getComments());
        }
    }
}