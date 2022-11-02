import java.util.Scanner;

public class P8_Letters_Change_Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] tokens = scanner.nextLine().split("\\s+");
        double totalSum = 0;
        for (String token : tokens) {
            char firstLetter = token.charAt(0);
            int firstLetterIndex = 0;
            int number = Integer.parseInt(token.substring(1, token.length() - 1));
            char lastLetter = token.charAt(token.length() - 1);
            int lastLetterIndex = 0;
            double currentTokenSum = 0;

            if (Character.isUpperCase(firstLetter)) {
                firstLetterIndex = firstLetter - 64;
                currentTokenSum += (1.0 * number) / firstLetterIndex;   // делим

            } else {
                firstLetterIndex = firstLetter - 96;
                currentTokenSum += (1.0 * number) * firstLetterIndex;    // умножаваме
            }

            if (Character.isUpperCase(lastLetter)) {
                lastLetterIndex = lastLetter - 64;
                currentTokenSum -= lastLetterIndex;         // вадим
            } else {
                lastLetterIndex = lastLetter - 96;
                currentTokenSum += lastLetterIndex;        // събираме
            }
            totalSum += currentTokenSum;
        }
        System.out.printf("%.2f",totalSum);
    }
}
