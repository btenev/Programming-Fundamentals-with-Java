import java.text.DecimalFormat;
import java.util.Scanner;

public class PF_08_FactorialDivision {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double one = Double.parseDouble(scanner.nextLine());
        double two = Double.parseDouble(scanner.nextLine());
        printFactorial(one, two);
    }
    private static void printFactorial (double one , double two) {
        double sumOne = 1;
        double sumTwo = 1;
        for (int i = 1; i <= one; i++) {
            sumOne *= i;
        }
        for (int j = 1; j <= two; j++) {
            sumTwo *= j;
        }
        double result = sumOne / sumTwo;
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        System.out.println(decimalFormat.format(result));
    }
}
