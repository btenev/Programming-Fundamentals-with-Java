import java.util.Scanner;

public class PF_05_Add_And_Subtract {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //You will receive 3 integers. Write a method sum to get the sum of the first two integers
        // and subtract method that subtracts the third integer from the result from the sum method.

        int one = Integer.parseInt(scanner.nextLine());
        int two = Integer.parseInt(scanner.nextLine());
        int three = Integer.parseInt(scanner.nextLine());
        int result = sum(one,two);
        int endResult = subtract(result, three);
        System.out.println(endResult);

    }
    public static Integer sum(int one, int two) {
        int sum = one + two;
        return sum;
    }

    public static Integer subtract(int result, int three) {
        int subtract = result - three;
        return subtract;
    }
}
