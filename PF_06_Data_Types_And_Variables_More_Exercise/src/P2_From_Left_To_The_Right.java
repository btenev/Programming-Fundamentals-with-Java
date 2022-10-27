import java.util.Scanner;

public class P2_From_Left_To_The_Right {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= n; i++) {
            double leftNumber = Double.parseDouble(scanner.next());
            double rightNumber = Double.parseDouble(scanner.next());
            int sum = 0;
            if (leftNumber > rightNumber) {
                double leftNum = Math.abs(leftNumber);
                while (leftNum > 0) {
                    sum += (leftNum % 10);
                    leftNum /= 10;
                }
            } else {
                double rightNum = Math.abs(rightNumber);
                while (rightNum > 0) {
                    sum += (rightNum % 10);
                    rightNum /= 10;
                }
            }
            System.out.println(Math.abs(sum));
        }
    }
  }