import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P2_A_Miner_Task {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String, Integer> collectedResources = new LinkedHashMap<>();
        while (!input.equals("stop")) {
            String resource = input;
            int quantity = Integer.parseInt(scanner.nextLine());
            if (!collectedResources.containsKey(resource)) {
                collectedResources.put(resource, quantity);
            } else {
                collectedResources.put(resource, collectedResources.get(resource) + quantity);
            }
            input = scanner.nextLine();
        }
//        collectedResources.forEach((string, integer) -> System.out.println(string + " -> " + integer));
        for (Map.Entry<String, Integer> entry : collectedResources.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}
