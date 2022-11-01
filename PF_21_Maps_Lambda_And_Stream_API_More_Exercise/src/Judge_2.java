import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Judge_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map<String, TreeMap<String, Integer>> contestDatabase = new LinkedHashMap<>();
        Map<String, Integer> individualDatabase = new TreeMap<>();
        while (!input.equals("no more time")) {
            String[] tokens = input.split(" -> ");
            String username = tokens[0];
            String contest = tokens[1];
            int points = Integer.parseInt(tokens[2]);
            boolean change = false;
            int result =0;
            contestDatabase.putIfAbsent(contest, new TreeMap<>()); // добавяме кънтеста ако не се съдържа в базата
            contestDatabase.get(contest).putIfAbsent(username, points); // добаваме юзъра ако не се съдържа в базата
            if (contestDatabase.get(contest).get(username) < points) { // ако юзъра се съдържа проверяваме настоящите точките по малко ли са от новите
                result = (points - contestDatabase.get(contest).get(username));
                contestDatabase.get(contest).put(username, points);
                change = true;
            }
            individualDatabase.putIfAbsent(username, 0);
            if (change) {
                individualDatabase.put(username,
                        individualDatabase.get(username) + result);
            } else {
                individualDatabase.put(username, individualDatabase.get(username) + points);
            }
            input = scanner.nextLine();
        }

        contestDatabase.forEach((key, value) -> { //int total = value.values().stream().mapToInt(Integer::intValue).sum();
            System.out.println(key + ": " + value.size()  + " participants");
            AtomicInteger num = new AtomicInteger();  // използваме атомик интеджър за брояч
            value.entrySet().stream().sorted((e1,e2) -> e2.getValue().compareTo(e1.getValue()))
                    .forEach(entry -> System.out.println(num.incrementAndGet() + ". "
                            + entry.getKey() + " <::> " + entry.getValue()));


        });
        System.out.println("Individual standings:");
        int[] num = {0};  // използваме масив за брояч
        individualDatabase.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEach((entry) -> System.out.println(++num[0] + ". " + entry.getKey() + " -> " + entry.getValue()));
    }
}
