import java.util.Scanner;

public class P3_Vacation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int peopleNumber = Integer.parseInt(scanner.nextLine());
        String groupType = scanner.nextLine();
        String dayOfWeek = scanner.nextLine();
        double pricePerPerson = 0;

        switch (groupType) {
            case"Students":
                switch (dayOfWeek) {
                    case "Friday":
                        pricePerPerson = 8.45;
                        break;
                    case "Saturday":
                        pricePerPerson = 9.80;
                        break;
                    case "Sunday":
                        pricePerPerson = 10.46;
                        break;
                }
                break;
            case "Business":
                switch (dayOfWeek) {
                    case "Friday":
                        pricePerPerson = 10.90;
                        break;
                    case "Saturday":
                        pricePerPerson = 15.60;
                        break;
                    case "Sunday":
                        pricePerPerson = 16;
                        break;
                }
                break;
            case "Regular":
                switch (dayOfWeek) {
                    case "Friday":
                        pricePerPerson = 15;
                        break;
                    case "Saturday":
                        pricePerPerson = 20;
                        break;
                    case "Sunday":
                        pricePerPerson = 22.50;
                        break;
                }
                break;

        }
        double totalPrice = peopleNumber * pricePerPerson;
        switch (groupType) {
            case "Students":
                if (peopleNumber >= 30) {
                    totalPrice *= 0.85;
                }
                break;
            case "Business":
                if (peopleNumber >= 100) {
                    totalPrice = (peopleNumber - 10) * pricePerPerson;
                }
                break;
            case "Regular":
                if (peopleNumber >= 10 && peopleNumber <= 20) {
                    totalPrice *= 0.95;
                }
        }
        System.out.printf("Total price: %.2f",totalPrice);
    }
}
