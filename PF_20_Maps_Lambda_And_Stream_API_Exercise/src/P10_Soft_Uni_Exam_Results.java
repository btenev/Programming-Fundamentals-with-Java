import java.util.*;

public class P10_Soft_Uni_Exam_Results {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map<String, ArrayList<Integer>> database = new TreeMap<>();
        Map<String, Integer> submissions = new TreeMap<>();
        while (!input.equals("exam finished")) {
            String[] tokens = input.split("-");
            String username = tokens[0];
            String bannedOrLanguage = tokens[1];
            if (bannedOrLanguage.equals("banned")) {

            } else {
                int points = Integer.parseInt(tokens[2]);
                submissions.putIfAbsent(bannedOrLanguage, 0);
                submissions.put(bannedOrLanguage, submissions.get(bannedOrLanguage) + 1);
                database.putIfAbsent(username, new ArrayList<>());
                database.get(username).add(points);
            }

            input = scanner.nextLine();
        }

    }
}
