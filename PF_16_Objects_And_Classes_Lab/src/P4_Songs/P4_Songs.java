package P4_Songs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P4_Songs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Song> songs = new ArrayList<>();
        // "{typeList}_{name}_{time}".
        for (int i = 0; i < n; i++) {
            String[] songTokens = scanner.nextLine().split("_");
            String typeList = songTokens[0];
            String name = songTokens[1];
            String time = songTokens[2];

            Song song = new Song(typeList, name, time);
            songs.add(song);
        }
        String type = scanner.nextLine();

        if (type.equals("all")) {
            for (Song song : songs) {
                System.out.println(song.getName());
            }
        } else {
            List<Song> filterSongs = songs.stream().filter(e -> e.getTypeList().equals(type)).collect(Collectors.toList());

            for (Song song : filterSongs) {
                System.out.println(song.getName());
            }
        }
    }
}
