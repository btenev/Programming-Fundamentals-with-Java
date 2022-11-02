import java.util.Scanner;

public class P6_Winning_Ticket {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] winningSymbols = {"@", "#", "$", "^"};
        String[] ticketCollection = scanner.nextLine().split("[, ]+");
        for (int i = 0; i < ticketCollection.length; i++) {
            String currentTicket = ticketCollection[i];
            boolean noMatch = true;
            if (isValid(currentTicket)) {
                for (String winningSymbol : winningSymbols) {
                    if (currentTicket.contains(winningSymbol)) {
                        int leftSideCount = countLeftSide(winningSymbol, currentTicket);
                        int rightSideCount = countRightSide(winningSymbol, currentTicket);
                        if ((leftSideCount >= 6 && leftSideCount <= 10 && rightSideCount >= 6 && rightSideCount < 10) ||
                                (leftSideCount >= 6 && leftSideCount < 10 && rightSideCount >= 6 && rightSideCount <= 10)) {
                            System.out.println("ticket "  + "\"" + currentTicket + "\"" + " - " + Math.min(leftSideCount, rightSideCount) + winningSymbol);
                            noMatch = false;
                        } else  if (leftSideCount == 10 && rightSideCount == 10) {
                            System.out.println("ticket "  + "\"" + currentTicket + "\"" + " - " + leftSideCount + winningSymbol + " Jackpot!");
                            noMatch = false;
                        }
                    }
                }
                if (noMatch) {
                    System.out.println("ticket " + "\"" + currentTicket + "\"" + " - " + "no match");
                }
            } else {
                System.out.println("invalid ticket");
            }
        }

    }

    private static int countRightSide(String symbol, String ticket) {
        int countRight = 0;
        for (int i = ticket.length() / 2; i < ticket.length(); i++) {
            char symbolChar = symbol.charAt(0);
            char currentSymbol = ticket.charAt(i);
            if (currentSymbol == symbolChar) {
                countRight++;
            } else if (countRight < 6) {
                countRight = 0;
            }
        }
        return countRight;
    }

    private static int countLeftSide(String symbol, String ticket) {
        int countLeft = 0;
        for (int i = 0; i < ticket.length() / 2; i++) {
            char symbolChar = symbol.charAt(0);
            char currentSymbol = ticket.charAt(i);
            if (currentSymbol == symbolChar) {
                countLeft++;
            } else if (countLeft < 6) {
                countLeft = 0;
            }
        }
        return countLeft;
    }

    private static boolean isValid(String ticket) {
        return ticket.length() == 20;
    }
}
