import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P5_Soft_Uni_Parking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, String> carRegistration = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String command = tokens[0];
            String userName = tokens[1];
            switch (command) {
                case "register":
                    String licensePlateNumber = tokens[2];
                    if (carRegistration.containsKey(userName)) {
                        System.out.println("ERROR: already registered with plate number " + carRegistration.get(userName));
                    } else {
                        carRegistration.put(userName, licensePlateNumber);
                        System.out.println(userName + " registered " + licensePlateNumber + " successfully");
                    }
                    break;
                case "unregister":
                    if (carRegistration.containsKey(userName)) {
                        carRegistration.remove(userName);
                        System.out.println( userName + " unregistered successfully");
                    } else {
                        System.out.println("ERROR: user " + userName + " not found");
                    }
                    break;
            }
        }
        carRegistration.forEach((key, value) -> System.out.println(key + " => " + value));
    }
}
