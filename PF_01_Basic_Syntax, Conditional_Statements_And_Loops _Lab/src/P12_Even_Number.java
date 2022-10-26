import java.util.Scanner;

public class P12_Even_Number {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean numberIsEven = false;
        int evenNumber = 0;

        while (true) {
            int digit = Integer.parseInt(scanner.nextLine());
            if (digit % 2 == 0) {
                evenNumber = digit;
                numberIsEven = true;
                break;
            } else {
                System.out.println("Please write an even number.");
            }
        }
        if (numberIsEven) {
            System.out.printf("The number is: %d", Math.abs(evenNumber));
        }
    }
}
