import java.util.Scanner;

public class P10_Rage_Expenses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int lostGameCount = Integer.parseInt(scanner.nextLine());
        double headsetPrice = Double.parseDouble(scanner.nextLine());
        double mousePrice = Double.parseDouble(scanner.nextLine());
        double keyboardPrice = Double.parseDouble(scanner.nextLine());
        double displayPrice = Double.parseDouble(scanner.nextLine());

        int trashedHeadsetCount = lostGameCount / 2;
        int trashedMouseCount = lostGameCount / 3;
        int trashedKeyboardCount = lostGameCount / 6;
        int trashDisplayCount = trashedKeyboardCount / 2;

        double totalExpense = (trashedHeadsetCount * headsetPrice) + (trashedMouseCount * mousePrice)
                + (trashedKeyboardCount * keyboardPrice) + (trashDisplayCount * displayPrice);
        System.out.printf("Rage expenses: %.2f lv.", totalExpense);
    }
}
