import java.util.Scanner;

public class P6_Balanced_Brackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        boolean opening = false;
        boolean closing = false;
        boolean isBalanced = false;
        int count = 0;
        for (int i = 1; i <= n; i++) {
            char symbol = scanner.nextLine().charAt(0);

            if (symbol == 40) {
                opening = true;
                count++;
                if (count > 1) {
                    break;
                }
            }
            if (symbol == 41) {
                closing = true;

            }
            if (!opening) {
                if (closing) {
                    break;
                }
            }
            if (opening && closing) {
                opening = false;
                closing = false;
                count = 0;
                isBalanced = true;
            }

        }
        if (isBalanced && !opening && !closing) {
            System.out.println("BALANCED");
        }
        else {
            System.out.println("UNBALANCED");
        }
    }
}

