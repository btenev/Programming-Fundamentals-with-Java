import java.util.Scanner;

public class PF_05_Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String product = scanner.nextLine();
        int quantity = Integer.parseInt(scanner.nextLine());
        printOrder(product,quantity);
    }

    private static void printOrder(String product, int quantity) {
        double price = 0;
        switch (product) {
            case "coffee":
                price = 1.50;
                break;
            case "water":
                price = 1.0;
                break;
            case "coke":
                price = 1.40;
                break;
            case "snacks":
                price = 2.0;
                break;
        }
        double orderSum = price * quantity;
        System.out.printf("%.2f", orderSum);
    }
}
