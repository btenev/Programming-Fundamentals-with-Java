import java.util.Scanner;

public class P9_Centuries_To_Minutes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double centuries = Integer.parseInt(scanner.nextLine());
        double years = centuries * 100;
        double days = years * 365.2422;
        double hours = days * 24;
        double minutes = 60 * hours;

        System.out.printf("%.0f centuries = %.0f years = %.0f days = %.0f hours = %.0f minutes", centuries, years, days, hours, minutes);
    }
}
