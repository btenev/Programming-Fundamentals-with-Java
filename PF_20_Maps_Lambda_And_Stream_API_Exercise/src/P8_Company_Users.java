import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class P8_Company_Users {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String, ArrayList<String>> dataBase = new TreeMap<>();
        while (!input.equals("End")) {
            String[] tokens = input.split(" -> ");
            String companyName = tokens[0];
            String id = tokens[1];
            dataBase.putIfAbsent(companyName,new ArrayList<>());
            if (!dataBase.get(companyName).contains(id)) {
                dataBase.get(companyName).add(id);
            }
            input = scanner.nextLine();
        }
        dataBase.forEach((key, value) -> {
            System.out.println(key);
            value.forEach(e -> System.out.println("-- " + e));
        });
    }
}
