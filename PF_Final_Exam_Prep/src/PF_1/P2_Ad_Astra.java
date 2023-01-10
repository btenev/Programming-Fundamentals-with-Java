package PF_1;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P2_Ad_Astra {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String regex = "([|#])(?<name>[A-Za-z ]+)\\1(?<date>[0-9]{2}\\/[0-9]{2}\\/[0-9]{2})\\1(?<calories>\\d{1,5})\\1";
        Pattern pattern = Pattern.compile(regex);
        String text = scanner.nextLine();
        Matcher matcher = pattern.matcher(text);
        int sum = 0;
        /*List <String> dataBase = new ArrayList<>(); */
        while (matcher.find()){
            //String item = matcher.group("name");
            ///String date = matcher.group("date");
            int calories = Integer.parseInt(matcher.group("calories"));
            sum += Integer.parseInt(matcher.group("calories"));
           /* dataBase.add(String.format("Item: %s, Best before: %s, Nutrition: %s", item, date, calories)); */

        }
        int daysFood = sum / 2000;
        System.out.println("You have food to last you for: " + daysFood + " days!");
       /* dataBase.forEach(System.out::println); */
        matcher.reset();
        while (matcher.find()) {
            String item = matcher.group("name");
            String date = matcher.group("date");
            int calories = Integer.parseInt(matcher.group("calories"));
            System.out.println("Item: " + item + ", Best before: " + date + ", Nutrition: " + calories);
        }
    }

}
