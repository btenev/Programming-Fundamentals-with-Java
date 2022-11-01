import java.text.DecimalFormat;
import java.util.*;

public class P4_Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map<String, List<Double>> products = new LinkedHashMap<>();

        while (!input.equals("buy")) {
            String productName = input.split("\\s+")[0];
            double price = Double.parseDouble(input.split("\\s+")[1]);
            double quantity = Double.parseDouble(input.split("\\s+")[2]);
            if(!products.containsKey(productName)) {
                products.put(productName,new ArrayList<>());
                products.get(productName).add(0, price);
                products.get(productName).add(1, quantity);
            } else {
                products.get(productName).set(0, price);
                products.get(productName).set(1, products.get(productName).get(1) + quantity);
            }
            input = scanner.nextLine();
        }
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        for (Map.Entry<String, List<Double>> entry : products.entrySet()) {
            System.out.println(entry.getKey() + " -> " + decimalFormat.format(entry.getValue().get(0) * entry.getValue().get(1)));
        }
    }
}
