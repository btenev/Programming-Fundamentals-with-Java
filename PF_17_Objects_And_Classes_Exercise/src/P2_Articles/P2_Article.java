package P2_Articles;

import java.util.Scanner;

public class P2_Article {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] tokens = scanner.nextLine().split(",\\s+");
        String title = tokens[0];
        String content = tokens[1];
        String author = tokens[2];
        Article article = new Article(title, content, author);
        int n = Integer.parseInt(scanner.nextLine());
        // Edit: better content
        for (int i = 0; i < n; i++) {
            String[] command = scanner.nextLine().split(": ");
            String commandName = command[0];
            String commandProperty = command[1];
            switch (commandName) {
                case "Edit":
                    article.edit(commandProperty);
                    break;
                case "ChangeAuthor":
                    article.changeAuthor(commandProperty);
                    break;
                case "Rename":
                    article.rename(commandProperty);
                    break;
            }
        }
        System.out.println(article);
    }
}
