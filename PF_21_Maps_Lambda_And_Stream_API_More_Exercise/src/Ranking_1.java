import java.util.*;

public class Ranking_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String, String> contestPassword = new LinkedHashMap<>();
        while (!input.equals("end of contests")) {
            String[] tokens = input.split(":");
            String contest = tokens[0];
            String password = tokens[1];
            contestPassword.putIfAbsent(contest, password);
            input = scanner.nextLine();
        }
        String secondInput = scanner.nextLine();
        Map<String, LinkedHashMap<String, Integer>> databaseUsers = new TreeMap<>();
        while (!secondInput.equals("end of submissions")) {
            String[] tokensSecond = secondInput.split("=>");
            String contestVerify = tokensSecond[0];
            String password = tokensSecond[1];
            String userName = tokensSecond[2];
            int userPoints = Integer.parseInt(tokensSecond[3]);

            if (isValidInput(contestPassword, contestVerify, password)) {
                databaseUsers.putIfAbsent(userName, new LinkedHashMap<>());
                if (!databaseUsers.get(userName).containsKey(contestVerify)) {
                    databaseUsers.get(userName).put(contestVerify, 0);
                }
                databaseUsers.get(userName)
                        .put(contestVerify, Math.max(userPoints, databaseUsers.get(userName).get(contestVerify)));
            }
            secondInput = scanner.nextLine();
        }
        printBestCandidate(databaseUsers);
        System.out.println("Ranking:");
        databaseUsers.forEach((key, value) -> {
            System.out.println(key);
            value.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).
                    forEach(entry -> System.out.println("#  " + entry.getKey() + " -> " + entry.getValue()));

        });
    }

    private static void printBestCandidate(Map<String, LinkedHashMap<String, Integer>> databaseUsers) {
        int maxSum = 0;
        String bestCandidate = "";
        for (Map.Entry<String, LinkedHashMap<String, Integer>> entry : databaseUsers.entrySet()) {
            int sum = entry.getValue().values().stream().mapToInt(e -> e).sum();
            String candidate = entry.getKey();
            if (sum > maxSum) {
                maxSum = sum;
                bestCandidate = candidate;
            }
        }
        System.out.println("Best candidate is " + bestCandidate +" with total " + maxSum + " points.");
    }

    private static boolean isValidInput(Map<String, String> contestPassword, String contestVerify, String password) {
        return contestPassword.containsKey(contestVerify)
                && contestPassword.get(contestVerify).equals(password);
    }
}
