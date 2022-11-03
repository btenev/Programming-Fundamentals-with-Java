import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P3_Soft_Uni_Bar_Income {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String regex = "%(?<name>[A-Z][a-z]*)%[^|$%.]*<(?<product>\\w+)>[^|$%.]*\\|(?<quantity>[0-9]*)\\|[^|$%.]*?(?<price>[0-9]+.?[0-9]*)\\$";
        Pattern pattern = Pattern.compile(regex);
        double totalSum = 0;
        String input = scanner.nextLine();
        DecimalFormat df = new DecimalFormat("0.00");
        while (!input.equals("end of shift")) {
            Matcher matcher = pattern.matcher(input);
            while (matcher.find()) {
                String customerName = matcher.group("name");
                String product = matcher.group("product");
                int quantity = Integer.parseInt(matcher.group("quantity"));
                double price = Double.parseDouble(matcher.group("price"));
                double currentPrice = quantity * price;
                totalSum += currentPrice;
                System.out.println(customerName + ": " + product + " - " + df.format(currentPrice));
            }
            input = scanner.nextLine();
        }
        System.out.println("Total income: " + df.format(totalSum));
    }
}
