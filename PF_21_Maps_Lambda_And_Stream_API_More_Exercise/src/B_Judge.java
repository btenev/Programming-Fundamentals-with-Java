import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class B_Judge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String, LinkedHashMap<String, Integer>> contestDatabase = new LinkedHashMap<>();
        Map<String, Integer> individualDatabase = new TreeMap<>();

        while (!input.equals("no more time")) {
            String[] tokens = input.split(" -> ");
            String username = tokens[0];
            String contest = tokens[1];
            int points = Integer.parseInt(tokens[2]);
            contestDatabase.putIfAbsent(contest, new LinkedHashMap<>());
            if (contestDatabase.get(contest).containsKey(username)) {
                if (contestDatabase.get(contest).get(username) < points) {
                    contestDatabase.get(contest).put(username, points);
                }
            } else {
                contestDatabase.get(contest).put(username, points);
            }
            input = scanner.nextLine();
        }
        for (LinkedHashMap<String, Integer> value : contestDatabase.values()) {
            for (Map.Entry<String, Integer> stringIntegerEntry : value.entrySet()) {
                String user = stringIntegerEntry.getKey();
                System.out.println(user);
            }
        }
    }
}