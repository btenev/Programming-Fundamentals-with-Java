import java.util.Scanner;

public class PF_10_Multiply_Evens_By_Odds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Math.abs(Integer.parseInt(scanner.nextLine()));
        getMultiplyEvenByOdds(number);
        System.out.println(getMultiplyEvenByOdds(number));
    }

    private static Integer getMultiplyEvenByOdds(int number) {
        int evenDigits = getSumOfEvenDigits(number);
        int oddDigits = getSumOfOddDigits(number);
        return evenDigits * oddDigits;
    }

    private static int getSumOfOddDigits(int number) {
        int sumOdd = 0;
        while (number > 0) {
            int currentDigit = number % 10;
            if (currentDigit % 2 != 0) {
                sumOdd += currentDigit;
            }
            number /= 10;
        }
        return sumOdd;

    }

    private static int getSumOfEvenDigits(int number) {
        int sumEven = 0;
        while (number > 0) {
            int currentDigit = number % 10;
            if (currentDigit % 2 == 0) {
                sumEven += currentDigit;
            }
            number /= 10;
        }
        return sumEven;
    }
}
