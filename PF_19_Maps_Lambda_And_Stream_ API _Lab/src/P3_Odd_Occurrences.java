import java.util.*;

public class P3_Odd_Occurrences {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] words = scanner.nextLine().toLowerCase().split("\\s+");
        Map<String, Integer> countWords = new LinkedHashMap<>();
        for (int i = 0; i < words.length; i++) {
            countWords.putIfAbsent(words[i], 0);
            countWords.put(words[i], countWords.get(words[i]) + 1);
        }
        List<String> odd = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : countWords.entrySet()) {
            if (entry.getValue() % 2 != 0) {
                odd.add(entry.getKey());
            }
        }
        //System.out.println(String.join(", ", odd));
        for (int i = 0; i < odd.size(); i++) {
            System.out.print(odd.get(i));
            if (i < odd.size() - 1) {
                System.out.print(", ");
            }
         }
    }
}
