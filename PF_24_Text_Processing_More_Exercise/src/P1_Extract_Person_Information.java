import java.util.Scanner;

public class P1_Extract_Person_Information {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= n; i++) {
            String string = scanner.nextLine();

            int startIndexName = string.indexOf('@');
            int endIndexName = string.indexOf("|");
            String name = string.substring(startIndexName + 1, endIndexName);

            int startIndexAge = string.indexOf('#');
            int endIndexAge = string.indexOf('*');
            String age = string.substring(startIndexAge + 1, endIndexAge);

            System.out.println(name + " is " + age + " years old.");
        }
    }
}
