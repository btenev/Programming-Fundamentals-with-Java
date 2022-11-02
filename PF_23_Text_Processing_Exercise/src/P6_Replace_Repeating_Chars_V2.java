import java.util.Scanner;

public class P6_Replace_Repeating_Chars_V2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        StringBuilder sb = new StringBuilder(input);

        for (int i = 0; i < sb.length() - 1; i++) {
            char currentChar = sb.charAt(i);
            char nextChar = sb.charAt(i + 1);

            if (currentChar == nextChar) {
                sb.deleteCharAt(i+1);
                i--;
            }
        }
        System.out.println(sb);
    }
}
