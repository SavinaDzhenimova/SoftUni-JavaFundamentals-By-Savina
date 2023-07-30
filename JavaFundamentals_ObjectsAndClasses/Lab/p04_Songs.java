package Lab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class p04_Songs {
    public static class Song {
        String typeList;
        String songName;
        String time;

        public Song(String typeList, String songName, String time) {
            this.typeList = typeList;
            this.songName = songName;
            this.time = time;
        }

        public String getSongName() {
            return this.songName;
        }

        public String getTypeList() {
            return this.typeList;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Song> songsList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] songInformation = scanner.nextLine().split("_");
            String typeList = songInformation[0];
            String songName = songInformation[1];
            String time = songInformation[2];

            Song currentSong = new Song(typeList, songName, time);
            songsList.add(currentSong);
        }

        String typeListToPrint = scanner.nextLine();
        if (typeListToPrint.equals("all")) {
            for (Song currentSong : songsList) {
                System.out.println(currentSong.getSongName());
            }
        } else {
            for (Song currentSong : songsList) {
                String currentTypeList = currentSong.getTypeList();
                if (typeListToPrint.equals(currentTypeList)) {
                    System.out.println(currentSong.getSongName());
                }
            }
        }
    }
}