import java.util.Scanner;

public class P5_Digits_Letters_And_Other {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Write a program that receives a single string and on the first line prints all the digits,
        // on the second – all the letters, and on the third – all the other characters.
        // There will always be at least one digit, one letter and one other characters.
        char[] data = scanner.nextLine().toCharArray();
        StringBuilder isLetter = new StringBuilder();
        StringBuilder isDigit = new StringBuilder();
        StringBuilder isSymbol = new StringBuilder();
        for (int i = 0; i < data.length; i++) {
            char currentSymbol = data[i];
            if (Character.isDigit(currentSymbol)) {
                isDigit.append(currentSymbol);
            }  else if (Character.isLetter(currentSymbol)) {
                isLetter.append(currentSymbol);
            } else {
                isSymbol.append(currentSymbol);
            }
        }
        System.out.println(isDigit);
        System.out.println(isLetter);
        System.out.println(isSymbol);
    }
}
