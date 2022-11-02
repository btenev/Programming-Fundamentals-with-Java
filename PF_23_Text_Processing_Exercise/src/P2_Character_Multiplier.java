import java.util.Scanner;

public class P2_Character_Multiplier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");
        String one = input[0];
        String two = input[1];
        int sum = calculateSum(one, two);
        System.out.println(sum);
    }
    private static int calculateSum (String one, String two) {
        char[] firstCharsArray = one.toCharArray();
        char[] secondCharsArray = two.toCharArray();
        int result = 0;
        char[] longerChar;
        char[] shorterChar;
        if (firstCharsArray.length > secondCharsArray.length) {
            shorterChar = secondCharsArray;
            longerChar = firstCharsArray;
        } else if (secondCharsArray.length > firstCharsArray.length) {
            shorterChar = firstCharsArray;
            longerChar = secondCharsArray;
        } else {
            shorterChar = firstCharsArray;
            longerChar = secondCharsArray;
        }

        for (int i = 0; i < shorterChar.length; i++) {
            char currentPositionOne = shorterChar[i];
            char currentPositionTwo = longerChar [i];
            result += currentPositionOne * currentPositionTwo;
        }
        for (int j = shorterChar.length; j < longerChar.length; j++) {
            char currentPosition = longerChar [j];
            result += currentPosition;
        }
        return result;
     }
 }
