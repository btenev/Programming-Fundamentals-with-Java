import java.util.Scanner;

public class P3_Gaming_Store {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double currentBalance = Double.parseDouble(scanner.nextLine());
        String game =  scanner.nextLine();
        double gamePrice = 0;
        double totalSpend = 0;
        boolean enoughMoney = true;

        while(!game.equals("Game Time")) {
            switch (game) {
                case "OutFall 4":
                    gamePrice = 39.99;
                    break;
                case "CS: OG":
                    gamePrice = 15.99;
                    break;
                case "Zplinter Zell":
                    gamePrice = 19.99;
                    break;
                case "Honored 2":
                    gamePrice = 59.99;
                    break;
                case "RoverWatch":
                    gamePrice = 29.99;
                    break;
                case "RoverWatch Origins Edition":
                    gamePrice = 39.99;
                    break;
                default:
                    System.out.println("Not Found");
                    game = scanner.nextLine();
                    continue;
            }

            if (currentBalance - gamePrice < 0){
                System.out.println("Too Expensive");
                game = scanner.nextLine();
                continue;
            } else {
                System.out.println("Bought " + game);
                currentBalance -= gamePrice;
                totalSpend += gamePrice;
            }
            if (currentBalance == 0) {
                System.out.println("Out of money!");
                enoughMoney = false;
                break;
            }
            game = scanner.nextLine();
        }
        if (enoughMoney) {
            System.out.printf("Total spent: $%.2f. Remaining: $%.2f", totalSpend, currentBalance);
        }
    }
}
