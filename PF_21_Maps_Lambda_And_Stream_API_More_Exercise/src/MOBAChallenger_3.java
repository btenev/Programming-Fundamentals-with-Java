import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class MOBAChallenger_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String, TreeMap<String, Integer>> playersDatabase = new TreeMap<>();
        while (!input.equals("Season end")) {
            if (input.contains("->")) {
                String[] tokens = input.split(" -> ");
                String player = tokens[0];
                String position = tokens[1];
                int skillPoints = Integer.parseInt(tokens[2]);

                playersDatabase.putIfAbsent(player, new TreeMap<>());
                playersDatabase.get(player).putIfAbsent(position, skillPoints);
                if (playersDatabase.get(player).get(position) < skillPoints) {
                    playersDatabase.get(player).put(position, skillPoints);
                }
            } else if (input.contains("vs")) {
                String[] versus = input.split(" vs ");
                String playerOne = versus[0];
                String playerTwo = versus[1];
                if (playersDatabase.containsKey(playerOne) && playersDatabase.containsKey(playerTwo)) {
                    boolean commonPosition = false;
                    for (String positionOne : playersDatabase.get(playerOne).keySet()) {
                        for (String positionTwo : playersDatabase.get(playerTwo).keySet()) {
                            if (positionOne.equals(positionTwo)) {
                                commonPosition = true;
                            }
                        }
                    }
                    if(commonPosition) {
                        if (playersDatabase.get(playerOne).values().stream().mapToInt(value -> value).sum() >
                                playersDatabase.get(playerTwo).values().stream().mapToInt(value -> value).sum()) {
                            playersDatabase.remove(playerTwo);
                        }
                    }
                }

            }



            input = scanner.nextLine();
        }
    }
}
