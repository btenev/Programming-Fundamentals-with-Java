import java.util.Random;
import java.util.Scanner;

public class P1_Advertisement_Message {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] phrases = {"Excellent product.", "Such a great product.", "I always use that product."
                , "Best product of its category.", "Exceptional product.", "I can’t live without this product."};
        String[] events = {"Now I feel good.", "I have succeeded with this product."
                , "Makes miracles. I am happy of the results!", "I cannot believe but now I feel awesome."
                , "Try it yourself, I am very satisfied.", "I feel great!"};
        String[] authors = {"Diana", "Petya", "Stella", "Elena", "Katya", "Iva", "Annie", "Eva"};
        String[] cities = {"Burgas", "Sofia", "Plovdiv", "Varna", "Ruse"};
        int n = Integer.parseInt(scanner.nextLine());
        Random random = new Random();

        for (int i = 1; i <= n; i++) {
            String phrase = phrases[random.nextInt(phrases.length - 1)];
            String event = events[random.nextInt(events.length- 1)];
            String author = authors[random.nextInt(events.length - 1)];
            String city = cities[random.nextInt(cities.length - 1)];
            //{phrase} {event} {author} – {city}.
            System.out.print(phrase + " " + event + " " + author + " - " + city);
            System.out.println();
        }
    }
}
