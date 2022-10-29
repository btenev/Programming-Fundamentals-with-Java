import java.util.Scanner;

public class PF_10_Top_Number {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= n; i++) {
            printTopInteger(i);
        }
    }

    private static void printTopInteger(int number) {
            int testNumber = number;
            boolean isOdd = false;
            boolean divisibleByEight = false;
            int sumOfDigits = 0;
            while (testNumber > 0) {
                int currentDigit = testNumber % 10;
                if (!isOdd) {
                    if (currentDigit % 2 != 0) {
                        isOdd = true;
                    }
                }
                sumOfDigits += currentDigit;
                testNumber /= 10;
            }
            if (sumOfDigits % 8 == 0) {
                divisibleByEight = true;
            }
            if (isOdd && divisibleByEight) {
                System.out.println(number);
            }
    }
}
