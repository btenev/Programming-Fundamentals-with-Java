package PF_2;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P2_Destination_Mapper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String regex = "(?<border>[=\\/])(?<destinations>[A-Z][A-Za-z]{2,})\\1";
        Pattern pattern = Pattern.compile(regex);
        String input = scanner.nextLine();
        Matcher matcher = pattern.matcher(input);
        ArrayList<String> destinationCollection = new ArrayList<>();
        int sum = 0;
        while (matcher.find()) {
            String destination = matcher.group("destinations");
            destinationCollection.add(destination);
            sum += destination.length();
        }
        System.out.println("Destinations: " + (String.join(", ", destinationCollection)));
        System.out.println("Travel Points: " + sum);
    }
}
