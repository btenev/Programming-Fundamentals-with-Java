import java.util.Scanner;

public class P5_HTML {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String title = scanner.nextLine();
        String content = scanner.nextLine();
        String input = scanner.nextLine();
        System.out.printf("<h1>%n    %s%n</h1>%n", title);
        System.out.printf("<article>%n    %s%n</article>%n", content);
        while (!input.equals("end of comments")) {
            String comment = input;
            System.out.printf("<div>%n    %s%n</div>%n", comment);

            input = scanner.nextLine();
        }
    }
}
