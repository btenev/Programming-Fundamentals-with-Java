import java.util.Scanner;

public class P_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double quantityOfFoodKg = Double.parseDouble(scanner.nextLine());
        double quantityOfHayKg = Double.parseDouble(scanner.nextLine());
        double quantityOfCoverKg = Double.parseDouble(scanner.nextLine());
        double guineaWeight = Double.parseDouble(scanner.nextLine());

        double quantityOfFoodGr = 1000 * quantityOfFoodKg;
        double quantityOfHayGr = 1000 * quantityOfHayKg;
        double quantityOfCoverGr = 1000 * quantityOfCoverKg;
        double guineaWeightGr = 1000 * guineaWeight;
        boolean notEnoughFood = false;

        for (int i = 1; i <= 30; i++) {
            quantityOfFoodGr -= 300;
            if (quantityOfFoodGr <= 0) {
                notEnoughFood = true;
            }
            if (i % 2 == 0) {
                double hayGiven = quantityOfFoodGr * 0.05;
                quantityOfHayGr -= hayGiven;
                if (quantityOfHayGr <= 0) {
                    notEnoughFood = true;
                }
            }
            if (i % 3 == 0) {
                double coverGiven = guineaWeightGr / 3;
                quantityOfCoverGr -= coverGiven;
                if (quantityOfCoverGr <= 0) {
                    notEnoughFood = true;
                }
            }
        }
        if (notEnoughFood) {
            System.out.println("Merry must go to the pet store!");
        } else {
            double endFood = quantityOfFoodGr / 1000;
            double endHay = quantityOfHayGr / 1000;
            double endCover = quantityOfCoverGr / 1000;
            System.out.printf("Everything is fine! Puppy is happy! Food: %.2f, Hay: %.2f, Cover: %.2f.", endFood, endHay, endCover);
        }
    }
}
