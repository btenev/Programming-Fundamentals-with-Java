import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P1_Train {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> passengerInWagons = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());
        int maxCapacity = Integer.parseInt(scanner.nextLine());
        String token = scanner.nextLine();

        while(!token.equals("end")) {
            String[]input = token.split("\\s+");

            if(input[0].equals("Add")) {
                int newWagon = Integer.parseInt(input[1]);
                passengerInWagons.add(newWagon);
            } else {
                int morePassengerToAdd = Integer.parseInt(input[0]);
                for (int i = 0; i < passengerInWagons.size(); i++) {
                    if(maxCapacity - passengerInWagons.get(i) >= morePassengerToAdd) {
                        passengerInWagons.set(i,passengerInWagons.get(i) + morePassengerToAdd);
                        break;
                    }
                }
            }
            token = scanner.nextLine();
        }
        System.out.println(passengerInWagons.toString().replaceAll("[\\[\\],]", ""));
    }
}
