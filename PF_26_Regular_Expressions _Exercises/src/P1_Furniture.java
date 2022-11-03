import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P1_Furniture {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String regex = ">>(?<furniture>[A-Za-z]+)<<(?<price>[0-9]+.?[0-9]*)!(?<quantity>[0-9]+)";
        String input = scanner.nextLine();
        List<String> furniture = new ArrayList<>();
        double totalSum = 0;
        while (!input.equals("Purchase")) {
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                furniture.add(matcher.group("furniture"));
                double price = Double.parseDouble(matcher.group("price"));
                int quantity = Integer.parseInt(matcher.group("quantity"));
                totalSum += price * quantity;
            }
            input = scanner.nextLine();
        }
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        System.out.println("Bought furniture:");
        furniture.forEach(System.out::println);
        System.out.println("Total money spend: " + decimalFormat.format(totalSum));
    }
}
