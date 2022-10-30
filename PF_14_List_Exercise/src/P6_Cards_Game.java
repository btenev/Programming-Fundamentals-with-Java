import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P6_Cards_Game {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> firstPlayerCards = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> secondPlayerCards = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        for (int i = 0; i < firstPlayerCards.size(); i++) {
            int firstPlayerCurrentCard = firstPlayerCards.get(i);
            int secondPlayerCurrentCard = secondPlayerCards.get(i);

            if (firstPlayerCurrentCard > secondPlayerCurrentCard) {
                firstPlayerCards.add(firstPlayerCurrentCard);
                firstPlayerCards.remove(0);
                firstPlayerCards.add(secondPlayerCurrentCard);
                secondPlayerCards.remove(0);
                i = -1;
            } else if (secondPlayerCurrentCard > firstPlayerCurrentCard) {
                secondPlayerCards.add(secondPlayerCurrentCard);
                secondPlayerCards.remove(0);
                secondPlayerCards.add(firstPlayerCurrentCard);
                firstPlayerCards.remove(0);
                i = -1;
            } else {
                firstPlayerCards.remove(0);
                secondPlayerCards.remove(0);
                i = -1;
            }
            if (firstPlayerCards.isEmpty() || secondPlayerCards.isEmpty()) {
                break;
            }
        }
        if (firstPlayerCards.isEmpty()) {
            int resultSecondPlayer = calculateResult(secondPlayerCards);
            System.out.printf("Second player wins! Sum: %d%n",resultSecondPlayer);
        } else {
            int resultFirstPlayer = calculateResult(firstPlayerCards);
            System.out.printf("First player wins! Sum: %d%n",resultFirstPlayer);
        }

    }

    private static int calculateResult(List<Integer> playerCards) {
        int sum = 0;
        for (int i = 0; i < playerCards.size(); i++) {
           sum += playerCards.get(i);
        }
        return sum;
    }
}