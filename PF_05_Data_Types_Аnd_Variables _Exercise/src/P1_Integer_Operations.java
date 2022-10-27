import java.util.Scanner;

public class P1_Integer_Operations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstNum = Integer.parseInt(scanner.nextLine());
        int secondNum = Integer.parseInt(scanner.nextLine());
        int thirdNum = Integer.parseInt(scanner.nextLine());
        int forthNum = Integer.parseInt(scanner.nextLine());

        int sum = firstNum + secondNum;
        int sumA = sum / thirdNum;
        int endSum = sumA * forthNum;

        System.out.println(endSum);
    }
}
