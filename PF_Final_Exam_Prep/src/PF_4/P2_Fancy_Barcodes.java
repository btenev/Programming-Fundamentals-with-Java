package PF_4;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P2_Fancy_Barcodes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String regex = "@#+(?<wanted>[A-Z][A-Za-z0-9]{4,}[A-Z])@#+";
        Pattern pattern = Pattern.compile(regex);
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= n; i++) {
            String current = scanner.nextLine();
            Matcher matcher = pattern.matcher(current);
            if (matcher.find()) {
                String found = matcher.group("wanted");
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < found.length(); j++) {
                    char symbol = found.charAt(j);
                    if (Character.isDigit(symbol)) {
                        sb.append(symbol);
                    }
                }
                found = sb.toString();
                if (found.isEmpty()) {
                    System.out.println("Product group: 00");
                } else {
                    System.out.println("Product group: " + found);
                }
            } else {
                System.out.println("Invalid barcode");
            }

        }
    }
}
