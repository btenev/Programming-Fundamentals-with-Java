import java.util.Scanner;

public class P3_Substring {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // On the first line you will receive a string. On the second line you will receive a second string.
        // Write a program that removes all of the occurrences of the first string in the second until there is no match.
        // At the end print the remaining string.
        String toRemove = scanner.nextLine();
        String input = scanner.nextLine();
        while (input.contains(toRemove)) {
//            input = input.replace(toRemove, "");
            int startIndex = input.indexOf(toRemove);
            int endIndex = startIndex + toRemove.length();
            String firstPart = input.substring(0,startIndex);
            String secondPart = input.substring(endIndex);
            input = firstPart + secondPart;
        }
        System.out.println(input);
    }
}
