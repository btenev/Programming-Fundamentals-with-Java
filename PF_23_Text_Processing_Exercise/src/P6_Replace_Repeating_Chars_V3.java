import java.util.Scanner;

public class P6_Replace_Repeating_Chars_V3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        StringBuilder sb = new StringBuilder();
        sb.append(input.charAt(0));
        for (int i = 0; i < input.length(); i++) {
            char currentSymbol = input.charAt(i);
            char lastAddedSymbol = sb.charAt(sb.length() - 1);

            if (currentSymbol != lastAddedSymbol) {
                sb.append(currentSymbol);
            }
        }
        System.out.println(sb);
    }
}
