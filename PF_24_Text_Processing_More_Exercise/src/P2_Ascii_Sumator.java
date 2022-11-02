import java.util.Scanner;

public class P2_Ascii_Sumator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String startSymbol = scanner.nextLine();
        char startSymbolChar = startSymbol.charAt(0);
        String endSymbol = scanner.nextLine();
        char endSymbolChar = endSymbol.charAt(0);
        String randomString = scanner.nextLine();


        int sum = 0;
        for (int i = 0; i < randomString.length(); i++) {
            char current = randomString.charAt(i);
            if (current > startSymbolChar && current < endSymbolChar)
            sum += current;
        }
        System.out.println(sum);
    }
}
