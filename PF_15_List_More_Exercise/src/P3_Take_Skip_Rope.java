import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P3_Take_Skip_Rope {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // skipTest_String044170”

        String input = scanner.nextLine();
        List<Integer> digits = new ArrayList<>();
        List<Character> nonDigits = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            char symbol = input.charAt(i);

            if (Character.isDigit(symbol)) {
                digits.add(Integer.parseInt(String.valueOf(symbol)));
            } else {
                nonDigits.add(symbol);
            }
        }
        List<Integer> takeList = new ArrayList<>();
        List<Integer> skipList = new ArrayList<>();

        for (int j = 0; j < digits.size(); j++) {
            if (j % 2 == 0) {
                takeList.add(digits.get(j));
            } else {
                skipList.add(digits.get(j));
            }
        }
        String result = "";
        while (!nonDigits.isEmpty()) {
            int digitToTake = takeList.get(0);
            takeList.remove(0);
            if (digitToTake > nonDigits.size()) {
                digitToTake = nonDigits.size();
            }
            for (int i = 0; i < digitToTake; i++) {
                result += nonDigits.get(0);
                nonDigits.remove(nonDigits.get(0));
            }

            int digitToSkip = skipList.get(0);
            skipList.remove(0);
            if(digitToSkip > nonDigits.size()) {
                digitToSkip = nonDigits.size();
            }
            for (int j = 0; j < digitToSkip; j++) {
                nonDigits.remove(nonDigits.get(0));
            }
            if (takeList.isEmpty() && skipList.isEmpty()){
                break;
            }
        }
        System.out.println(result);
    }
}
