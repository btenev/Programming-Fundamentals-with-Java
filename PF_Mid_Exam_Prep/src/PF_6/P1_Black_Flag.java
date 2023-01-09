package PF_6;

import java.util.Scanner;

public class P1_Black_Flag {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int daysOfPlunder = Integer.parseInt(scanner.nextLine());
        int dailyPlunder = Integer.parseInt(scanner.nextLine());
        double expectedPlunder = Double.parseDouble(scanner.nextLine());
        double totalPlunder = 0;
        int count = 0;

        for (int i = 0; i < daysOfPlunder; i++) {
            totalPlunder += dailyPlunder;
            count++;
            if (count % 3 == 0) {
                totalPlunder += dailyPlunder * 0.50;
            }
            if (count % 5 == 0) {
                totalPlunder *= 0.70;
            }
        }

        if (totalPlunder >= expectedPlunder) {
            System.out.printf("Ahoy! %.2f plunder gained.%n", totalPlunder);
        } else {
            double percentagePlunder = (totalPlunder / expectedPlunder) * 100;
            System.out.printf("Collected only %.2f%% of the plunder.%n", percentagePlunder);
        }
    }
}

