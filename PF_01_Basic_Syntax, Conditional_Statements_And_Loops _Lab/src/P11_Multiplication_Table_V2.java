import java.util.Scanner;

public class P11_Multiplication_Table_V2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        int times = Integer.parseInt(scanner.nextLine());

        do {
            int result = number * times;
            System.out.printf("%d X %d = %d%n", number, times, result);
            times++;
        } while (times <= 10);
    }
}
