package PF_3;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P2_Mirror_Words {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String regex = "([@#])(?<firstWord>[A-Zaa-z]{3,})\\1\\1(?<secondWord>[A-Zaa-z]{3,})\\1";
        Pattern pattern = Pattern.compile(regex);
        String toExplore = scanner.nextLine();
        Matcher matcher = pattern.matcher(toExplore);

        ArrayList<String> mirrorDatabase = new ArrayList<>();
        int counter = 0;
        while (matcher.find()) {
            counter++;
            String firstWord = matcher.group("firstWord");
            String secondWord = matcher.group("secondWord");
            StringBuilder temp = new StringBuilder(secondWord);
            temp.reverse();
            String reversedSecondWord = temp.toString();
            if (firstWord.equals(reversedSecondWord)) {
                mirrorDatabase.add(String.format("%s <=> %s", firstWord, secondWord));
            }
        }
        if (counter == 0) {
            System.out.println("No word pairs found!");
        } else {
            System.out.println(counter + " word pairs found!");
        }
        if (mirrorDatabase.isEmpty()) {
            System.out.println("No mirror words!");
        } else {
            System.out.println("The mirror words are:");
            System.out.println(String.join(", ", mirrorDatabase));
        }
    }
}
