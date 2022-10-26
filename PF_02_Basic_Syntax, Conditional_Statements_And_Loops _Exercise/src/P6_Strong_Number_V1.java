import java.util.Scanner;

public class P6_Strong_Number_V1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        int number = Integer.parseInt(text);
        int sum = 0;

        while (number > 0) {
            int currentDigit = number % 10;
            int currentSum = 1;
            for (int i = 1; i <= currentDigit ; i++) {
                currentSum *= i;
            }
            sum += currentSum;
            number /= 10;
        }
        int compare = Integer.parseInt(text);
        if (sum == compare) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }
}
