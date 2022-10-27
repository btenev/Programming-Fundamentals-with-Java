import java.util.Scanner;

public class P2_Pounds_To_Dollars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double pounds = Double.parseDouble(scanner.nextLine());
        double dollars = 1.36 * pounds;
        System.out.printf("%.3f", dollars);
    }
}
