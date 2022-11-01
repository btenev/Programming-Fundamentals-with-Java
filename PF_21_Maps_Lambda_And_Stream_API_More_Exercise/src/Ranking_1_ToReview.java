import java.util.*;

public class Ranking_1_ToReview {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String, String> contestPassword = new LinkedHashMap<>();
        while (!input.equals("end of contests")) {
            String[] tokens = input.split(":");
            String contest = tokens[0];
            String password = tokens[1];
            contestPassword.putIfAbsent(contest,password);
            input = scanner.nextLine();
        }
        String secondInput = scanner.nextLine();
        Map<String, List<String>> databaseUsers = new TreeMap<>();
        while (!secondInput.equals("end of submissions")) {
            String[] tokensSecond = secondInput.split("=>");
            String contestVerify = tokensSecond[0];
            String password = tokensSecond[1];
            String userName = tokensSecond[2];
            int userPoints = Integer.parseInt(tokensSecond[3]);
            if (isValidInput(contestPassword, contestVerify, password)) {
                databaseUsers.putIfAbsent(userName, new ArrayList<>());
                if (!databaseUsers.get(userName).contains(contestVerify)) {
                    databaseUsers.get(userName).add(contestVerify);
                    databaseUsers.get(userName).add("0");
                }
                for (int i = 0; i < databaseUsers.get(userName).size(); i++) {
                    if (databaseUsers.get(userName).get(i).equals(contestVerify)) {
                        int currentPoints = Integer.parseInt(String.valueOf(databaseUsers.get(userName).get(i + 1)));
                        if (currentPoints < userPoints) {
                            databaseUsers.get(userName).remove(i + 1);
                            databaseUsers.get(userName).add(i + 1,String.valueOf(userPoints));
                            break;
                        }
                    }
                }

            }

            secondInput = scanner.nextLine();
        }
        printBestCandidate(databaseUsers);
        System.out.println("Ranking:");
        int counter = 0;
        databaseUsers.entrySet().stream().forEach(entry -> {
            System.out.println(entry.getValue());


        });
    }

    private static void printBestCandidate(Map<String, List <String>> databaseUsers) {
        String bestCandidate = "";
        int maxPoints = 0;
        for (Map.Entry<String, List<String>> currentUser : databaseUsers.entrySet()) {
            String user = currentUser.getKey();
            List<String> list = currentUser.getValue();
            int sum = 0;
            for (int i = 0; i < list.size(); i++) {
                if (i % 2 != 0) {
                    sum += Integer.parseInt(list.get(i));
                }
            }
            if (sum > maxPoints) {
                maxPoints = sum;
                bestCandidate = user;
            }
        }
        System.out.println("Best candidate is " + bestCandidate +" with total " + maxPoints + " points.");
    }

    private static boolean isValidInput(Map<String,String> contestPassword, String contestVerify, String password) {
        return contestPassword.containsKey(contestVerify)
                && contestPassword.get(contestVerify).equals(password);
    }
}
