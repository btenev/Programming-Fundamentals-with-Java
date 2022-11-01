import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class P9_Force_Book {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String, ArrayList<String>> dataBase = new HashMap<>();
        while (!input.equals("Lumpawaroo")) {

            if (input.contains(" | ")) {
                String forceSide = input.split(" \\| ")[0];
                String forceUser = input.split(" \\| ")[1];
                if (!dataBase.containsKey(forceUser)) {
                    dataBase.put(forceSide, new ArrayList<>());
                    dataBase.get(forceSide).add(forceUser);
                }
            } else {
                String forceUser = input.split(" -> ")[0];
                String forceSide = input.split(" -> ")[1];
                if (dataBase.containsKey(forceUser)) {
                    dataBase.entrySet().forEach(entry -> entry.getValue().remove(forceUser));
                    dataBase.put(forceSide, dataBase.get(forceSide));
                } else {
                    dataBase.get(forceSide).add(forceUser);
                    System.out.println( forceUser +" joins the " +forceSide + " side!");
                }
            }
            input = scanner.nextLine();
        }
        dataBase.entrySet().stream()
                .sorted((e1,e2) -> Integer.compare(e2.getValue().size(),e1.getValue().size())).filter(entry -> entry.getValue().size() != 0)
                .forEach(entry -> {System.out.println("Side: " + entry.getKey() + ", " + "Members: " + entry.getValue().size());
                    entry.getValue().stream().sorted().forEach(e -> System.out.println("! " + e));
                });

    }
}
