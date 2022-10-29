import java.util.Scanner;

public class PF_11_Math_Operations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numOne = Integer.parseInt(scanner.nextLine());
        String operator = scanner.nextLine();
        int numTwo = Integer.parseInt(scanner.nextLine());

        double endResult = calculate(numOne, operator, numTwo);
        System.out.printf("%.0f", endResult);

    }

    private static double calculate(int numOne, String operator, int numTwo) {
        double result = 0;
        switch (operator) {
            case "*":
                result = numOne * numTwo;
                break;
            case "+":
                result = numOne + numTwo;
                break;
            case "-":
                result = numOne - numTwo;
                break;
            case "/":
                result = 1.0 * numOne / numTwo;
                break;
        }

        return result;

    }

}
