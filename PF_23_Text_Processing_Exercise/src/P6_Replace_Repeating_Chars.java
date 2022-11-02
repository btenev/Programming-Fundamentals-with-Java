import java.util.Scanner;

public class P6_Replace_Repeating_Chars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < input.length() - 1; i++) {
            char currentSymbol = input.charAt(i);
            char nextSymbol = input.charAt(i + 1);
            if (currentSymbol != nextSymbol) {
                sb.append(currentSymbol);
            }
        }
        sb.append(input.charAt(input.length() - 1));
        System.out.println(sb);
    }
}
