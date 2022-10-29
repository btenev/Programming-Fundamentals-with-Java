import java.util.Scanner;

public class PF_09_Palindrome_Integers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        while (!input.equals("END")) {
            boolean isPalindrome = isPalindrome(input);
            System.out.println(isPalindrome);
            input = scanner.nextLine();
        }

    }
    private static boolean isPalindrome (String number) {
        String normal = number;
        String reversed = "";
        for (int i = number.length() - 1; i >= 0; i--) {
            char current = normal.charAt(i);
            reversed += current;
        }
        return normal.equals(reversed);
    }
}
