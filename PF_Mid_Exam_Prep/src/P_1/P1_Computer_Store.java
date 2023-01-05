package one;

import java.text.DecimalFormat;
import java.util.Scanner;

public class P1_Computer_Store {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        double sumPriceNoTax = 0;

        while(true) {
            if (input.equals("special") || input.equals("regular")) {
                break;
            }
            double priceNoTax = Double.parseDouble(input);
            if (priceNoTax < 0) {
                System.out.println("Invalid price!");
            } else {
                sumPriceNoTax += priceNoTax;
            }

            input = scanner.nextLine();
        }
        double taxes = sumPriceNoTax * 0.20;
        double totalPrice = sumPriceNoTax + taxes;
        if (totalPrice > 0) {
            System.out.println("Congratulations you've just bought a new computer!");
            DecimalFormat decimalFormat = new DecimalFormat("0.00");
            System.out.println("Price without taxes: " + decimalFormat.format(sumPriceNoTax) + "$");
            System.out.println("Taxes: " + decimalFormat.format(taxes) + "$");
            if (input.equals("special")) {
                totalPrice *= 0.90;
            }
            System.out.println("-----------");
            System.out.println("Total price: " + decimalFormat.format(totalPrice) + "$");
        } else {
            System.out.println("Invalid order!");
        }
    }
}
