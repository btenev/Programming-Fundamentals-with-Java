import java.util.Scanner;

public class P3_Floating_Equality {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double number1 = Double.parseDouble(scanner.nextLine());
        double number2 = Double.parseDouble(scanner.nextLine());

        if (Math.abs(number1 - number2) < 0.000001) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }


    }
}
