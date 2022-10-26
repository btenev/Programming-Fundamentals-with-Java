import java.util.Scanner;

public class P2_Division {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        boolean divisibleBy2 = false;
        boolean divisibleBy3 = false;
        boolean divisibleBy7 = false;
        boolean divisibleBy10 = false;

        if (number % 2 == 0) {
            divisibleBy2 = true;
        }
        if (number % 3 == 0) {
            divisibleBy3 = true;
        }
        if (number % 7 == 0) {
            divisibleBy7 = true;

        }
        if (number % 10 == 0) {
            divisibleBy10 = true;
        }
        if (divisibleBy2 && divisibleBy3 && divisibleBy10) {
            System.out.println("The number is divisible by "+ 10);
        } else if (divisibleBy7 && divisibleBy10) {
            System.out.println("The number is divisible by "+ 10);
        } else if (divisibleBy2 && divisibleBy3) {
            System.out.println("The number is divisible by "+ 6);
        }  else if (divisibleBy3 && divisibleBy7) {
            System.out.println("The number is divisible by " + 7);
        }  else if (divisibleBy7 && divisibleBy2) {
            System.out.println("The number is divisible by " + 7);
        } else if (divisibleBy7) {
            System.out.println("The number is divisible by " + 7);
        } else if (divisibleBy10) {
            System.out.println("The number is divisible by " + 10);
        } else if (divisibleBy2) {
            System.out.println("The number is divisible by "+ 2);
        } else if (divisibleBy3) {
            System.out.println("The number is divisible by "+ 3);
        } else {
            System.out.println("Not divisible");
        }

    }
}
