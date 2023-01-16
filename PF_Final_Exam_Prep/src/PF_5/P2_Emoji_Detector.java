package PF_5;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P2_Emoji_Detector {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String regexValidEmoji = "(::|\\*\\*)(?<vital>[A-Z][a-z]{2,})\\1";
        Pattern patternEmoji = Pattern.compile(regexValidEmoji);

        String digits = "[0-9]";
        Pattern patternDigits = Pattern.compile(digits);
        String string = scanner.nextLine();
        int coolThreshold = 1;
        Matcher matcherDigits = patternDigits.matcher(string);
        while (matcherDigits.find()) {
            int toAdd = Integer.parseInt(matcherDigits.group());
            coolThreshold *= toAdd;
        }
        System.out.println("Cool threshold: " + coolThreshold);
        Matcher matcherEmoji = patternEmoji.matcher(string);
        List<String> coolEmoji = new ArrayList<>();
        int counter = 0;
        while (matcherEmoji.find()) {
            String viableEmoji = matcherEmoji.group();
            counter++;
            int sumEmoji = 0;
            for (int i = 0; i < viableEmoji.length(); i++) {
                char currentSymbol = viableEmoji.charAt(i);
                if (Character.isLetter(currentSymbol))
                sumEmoji += currentSymbol;
            }
           if (sumEmoji > coolThreshold) {
               coolEmoji.add(viableEmoji);
           }
        }
        System.out.println(counter + " emojis found in the text. The cool ones are:");
        for (String emoji : coolEmoji) {
            System.out.println(emoji);
        }
    }
}
