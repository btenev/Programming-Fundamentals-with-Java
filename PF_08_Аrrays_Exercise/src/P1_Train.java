import java.util.Scanner;

public class P1_Train {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int[] peopleCount = new int[n];
        int sumAll = 0;
        for (int i = 0; i < n; i++) {
            peopleCount [i] = Integer.parseInt(scanner.nextLine());
            sumAll += peopleCount [i];
        }
        for (int people : peopleCount) {
            System.out.print(people + " ");
        }
        System.out.println();
        System.out.println(sumAll);
    }
}
