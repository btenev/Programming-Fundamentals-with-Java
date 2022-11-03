import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P1_Winning_Ticket {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("[, ]+");
        String jackpotRegex = "(?<jackpot>[@]{20}|[#]{20}|[$]{20}|[\\^]{20})";
        Pattern jackpotPattern = Pattern.compile(jackpotRegex);
        String winRegex = "(?<winingTicket>[@]{6,9}|[#]{6,9}|[$]{6,9}|[\\^]{6,9})";
        Pattern winPattern = Pattern.compile(winRegex);

        for (int i = 0; i < input.length; i++) {
            String symbolsToMatch = input[i];
            Matcher jackpotMatcher = jackpotPattern.matcher(symbolsToMatch);
            if (symbolsToMatch.length() == 20) {
                if (jackpotMatcher.find()) {
                    String jackpot = jackpotMatcher.group();
                    System.out.printf("ticket \"%s\" - 10%s Jackpot!%n", jackpot, jackpot.charAt(0));
                    continue;
                }

                String rightSide = symbolsToMatch.substring(0, 10);
                String leftSide = symbolsToMatch.substring(10);
                Matcher winMatcherRight = winPattern.matcher(rightSide);
                Matcher winMatcherLeft = winPattern.matcher(leftSide);
                int lengthRight = 0;
                int lengthLeft = 0;
                String winningSymbolRight = "";
                String winningSymbolLeft = "";
                boolean right = false;
                boolean left = false;
                if (winMatcherRight.find()) {
                    String currentWinCombinationRight = winMatcherRight.group();
                    lengthRight = currentWinCombinationRight.length();
                    winningSymbolRight = String.valueOf(currentWinCombinationRight.charAt(0));
                    right = true;
                }
                if (winMatcherLeft.find()) {
                    String currentWinCombinationLeft = winMatcherLeft.group();
                    winningSymbolLeft = String.valueOf(currentWinCombinationLeft.charAt(0));
                    lengthLeft = currentWinCombinationLeft.length();
                    left = true;
                }
                if (right & left & winningSymbolRight.equals(winningSymbolLeft)) {
                    System.out.println("ticket \"" + symbolsToMatch + "\" - " + Math.min(lengthLeft, lengthRight) + winningSymbolLeft);
                } else {
                    System.out.println("ticket \"" + symbolsToMatch + "\" - no match");
                }
            } else {
                System.out.println("invalid ticket");
            }
        }
    }
}
