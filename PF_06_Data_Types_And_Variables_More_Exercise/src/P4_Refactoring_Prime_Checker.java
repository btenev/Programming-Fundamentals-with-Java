import java.util.Scanner;

public class P4_Refactoring_Prime_Checker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        for (int currentNumber = 2; currentNumber <= n; currentNumber++) {
            boolean isPrime = true;
            for (int divider = 2; divider < currentNumber; divider++) {
                if (currentNumber % divider == 0) {
                    isPrime = false;
                    break;
                }
            }
            System.out.printf("%d -> %b%n", currentNumber, isPrime);
        }

    }
}
