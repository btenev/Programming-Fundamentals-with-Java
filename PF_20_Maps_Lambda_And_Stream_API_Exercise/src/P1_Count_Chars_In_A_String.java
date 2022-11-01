import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P1_Count_Chars_In_A_String {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        Map<Character, Integer> countSymbols = new LinkedHashMap<>();
        for (int i = 0; i < text.length(); i++) {
            char currentSymbol = text.charAt(i);
            if (currentSymbol == ' ') {
                continue;
            }
            if (!countSymbols.containsKey(currentSymbol)) {
                countSymbols.put(currentSymbol, 0);
            }
            countSymbols.put(currentSymbol, countSymbols.get(currentSymbol) + 1);
        }
//        countSymbols.forEach((character, integer) -> System.out.println(character + " -> " + integer));
        for (Map.Entry<Character, Integer> entry : countSymbols.entrySet()) {
            System.out.println(entry.getKey() + " - > " + entry.getValue());
        }
    }
}
