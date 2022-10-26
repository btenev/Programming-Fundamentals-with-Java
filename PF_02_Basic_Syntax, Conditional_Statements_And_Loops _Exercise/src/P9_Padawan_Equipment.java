import java.util.Scanner;

public class P9_Padawan_Equipment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        int countStudents = Integer.parseInt(scanner.nextLine());
        double priceLightSaber = Double.parseDouble(scanner.nextLine());
        double priceRobe = Double.parseDouble(scanner.nextLine());
        double priceBelt = Double.parseDouble(scanner.nextLine());

        double sumLightSabers = Math.ceil(countStudents * 1.10) * priceLightSaber;
        double sumRobe = priceRobe * countStudents;
        int freeBelts = countStudents / 6;
        double sumBelts = priceBelt * (countStudents - freeBelts);
        double sumAll = sumLightSabers + sumRobe + sumBelts;
        if (sumAll <= budget) {
            System.out.printf("The money is enough - it would cost %.2flv.", sumAll);
        } else {
            System.out.printf("George Lucas will need %.2flv more.", sumAll - budget);
        }
    }
}
