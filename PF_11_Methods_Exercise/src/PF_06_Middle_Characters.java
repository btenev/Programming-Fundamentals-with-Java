import java.util.Scanner;

public class PF_06_Middle_Characters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String result = printMiddleCharacter(input);
        System.out.println(result);

    }

    private static String printMiddleCharacter (String input) {
        String result = "";
        if (input.length()  % 2 == 0) {
            result += input.charAt((input.length() - 1) / 2);
            result += input.charAt(input.length() / 2);;
        } else {
            result += input.charAt((input.length() - 1) / 2);
        }
        return result;
    }
}
