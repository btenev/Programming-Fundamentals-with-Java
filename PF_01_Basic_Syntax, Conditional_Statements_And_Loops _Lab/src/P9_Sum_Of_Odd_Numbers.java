import java.util.Scanner;

public class P9_Sum_Of_Odd_Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int sum = 0;
        int count = 0;


        for (int i = 1; i <= 100; i += 2) {
            sum += i;
            count++;
            System.out.println(i);
            if (count >= n) {
                break;
            }
        }
        System.out.println("Sum: " + sum);
    }
}
