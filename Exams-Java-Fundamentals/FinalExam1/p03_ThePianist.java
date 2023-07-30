package FinalExam1;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class p03_ThePianist {
    public static class Piece {
        String composer;
        String key;

        public Piece(String composer, String key) {
            this.composer = composer;
            this.key = key;
        }

        public String getKey() {
            return this.key;
        }

        public String getComposer() {
            return this.composer;
        }

        public void setKey(String key) {
            this.key = key;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfPieces = Integer.parseInt(scanner.nextLine());
        LinkedHashMap<String, Piece> piecesMap = new LinkedHashMap<>();

        for (int i = 0; i < numberOfPieces; i++) {
            String[] tokens = scanner.nextLine().split("\\|");
            String piece = tokens[0];
            String composer = tokens[1];
            String key = tokens[2];

            Piece currentPiece = new Piece(composer, key);
            piecesMap.put(piece, currentPiece);
        }

        String command = scanner.nextLine();

        while (!command.equals("Stop")) {
            String[] commands = command.split("\\|");
            String piece = commands[1];
            boolean isExist = false;

            switch (commands[0]) {
                case "Add":
                    String composer = commands[2];
                    String key = commands[3];
                    Piece newPiece = new Piece(composer, key);

                    for (Map.Entry<String, Piece> entry : piecesMap.entrySet()) {
                        if (entry.getKey().equals(piece)) {
                            isExist = true;
                            break;
                        }
                    }

                    if (isExist) {
                        System.out.printf("%s is already in the collection!%n", piece);
                    } else {
                        piecesMap.put(piece, newPiece);
                        System.out.printf("%s by %s in %s added to the collection!%n", piece, composer, key);
                    }
                    break;
                case "Remove":
                    for (Map.Entry<String, Piece> entry : piecesMap.entrySet()) {
                        if (entry.getKey().equals(piece)) {
                            isExist = true;
                            break;
                        }
                    }

                    if (isExist) {
                        piecesMap.remove(piece);
                        System.out.printf("Successfully removed %s!%n", piece);
                    } else {
                        System.out.printf("Invalid operation! %s does not exist in the collection.%n", piece);
                    }
                    break;
                case "ChangeKey":
                    String newKey = commands[2];

                    for (Map.Entry<String, Piece> entry : piecesMap.entrySet()) {
                        if (entry.getKey().equals(piece)) {
                            isExist = true;
                            break;
                        }
                    }

                    if (isExist) {
                        piecesMap.get(piece).setKey(newKey);
                        System.out.printf("Changed the key of %s to %s!%n", piece, newKey);
                    } else {
                        System.out.printf("Invalid operation! %s does not exist in the collection.%n", piece);
                    }
                    break;
            }

            command = scanner.nextLine();
        }

        for (Map.Entry<String, Piece> entry : piecesMap.entrySet()) {
            System.out.printf("%s -> Composer: %s, Key: %s%n",
                    entry.getKey(), entry.getValue().getComposer(), entry.getValue().getKey());
        }
    }
}