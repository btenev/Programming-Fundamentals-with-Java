import java.util.*;

public class P6_List_Of_Products {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<String> productList = new ArrayList<>();
        for (int i = 1; i <= n ; i++) {
            String product = scanner.nextLine();
            productList.add(product);
        }
        Collections.sort(productList);

        for (int j = 0; j < productList.size(); j++) {
            System.out.printf("%d.%s%n", j + 1, productList.get(j));
        }
    }
}
