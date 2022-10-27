import java.util.Scanner;

public class P4_Sum_Of_Chars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int sum = 0;
        for (int i = 1; i <= n ; i++) {
            char currentLetter = scanner.nextLine().charAt(0);
            sum += currentLetter;
        }
        System.out.println("The sum equals: " + sum);
    }
}
