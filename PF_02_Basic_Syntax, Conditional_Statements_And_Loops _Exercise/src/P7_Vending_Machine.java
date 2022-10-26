import java.util.Scanner;

public class P7_Vending_Machine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

         String text = scanner.nextLine();
        double sumInput = 0;
        double priceProduct = 0;
        boolean validProduct = true;
        while (!text.equals("Start")) {
            double coinInput = Double.parseDouble(text);
            if (coinInput == 0.1) {
                sumInput += 0.1;
            } else if (coinInput == 0.2) {
                sumInput += 0.2;
            } else if (coinInput == 0.5) {
                sumInput += 0.5;
            } else if (coinInput == 1) {
                sumInput += 1;
            } else if (coinInput == 2) {
                sumInput += 2;
            } else {
                System.out.printf("Cannot accept %.2f%n", coinInput);
            }

            text = scanner.nextLine();
        }
        text = scanner.nextLine();
        while (!text.equals("End")) {
            switch (text) {
                case "Nuts":
                    priceProduct = 2.0;
                    break;
                case "Water":
                    priceProduct = 0.7;
                    break;
                case "Crisps":
                    priceProduct = 1.5;
                    break;
                case "Soda":
                    priceProduct = 0.8;
                    break;
                case "Coke":
                    priceProduct = 1.0;
                    break;
                default:
                    validProduct = false;
                    System.out.println("Invalid product");
            }
            if(validProduct) {
                if (sumInput >= priceProduct) {
                    sumInput -= priceProduct;
                    System.out.println("Purchased " + text);
                } else {
                    System.out.println("Sorry, not enough money");
                }
            }
            text = scanner.nextLine();
        }
        System.out.printf("Change: %.2f",sumInput);
    }
}
