package P4_Article_V2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class P4_Articles_V2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Article> articles = new ArrayList<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <= n; i++) {
            String[] articleData = scanner.nextLine().split(",\\s+");
            String title = articleData[0];
            String content = articleData[1];
            String author = articleData[2];

            Article article = new Article(title, content, author);
            articles.add(article);
        }
        String command = scanner.nextLine();
        switch (command) {
            case "title":
                articles.sort(Comparator.comparing(Article::getTitle));
                break;
            case "content":
                articles.sort(Comparator.comparing(Article::getContent));
                break;
            case "author":
                articles.sort(Comparator.comparing(Article::getAuthor));
                break;
        }
        for (Article article : articles) {
            System.out.println(article);
        }
    }
}
