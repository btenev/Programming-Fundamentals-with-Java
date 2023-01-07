package P_5;

import java.util.Scanner;

public class P2_Mu_Online {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int health = 100;
        int bitcoins = 0;
        // rat 10|bat 20|potion 10|rat 10|chest 100|boss 70|chest 1000
        String[] tokens = scanner.nextLine().split("\\|");
        boolean areAlive = true;
        for (int i = 0; i < tokens.length; i++) {
            String[] room = tokens[i].split("\\s+");
            String itemOrMonster = room[0];
            if(!areAlive) {
                break;
            }
            switch (itemOrMonster) {
                case "potion":
                    int healingPotion = Integer.parseInt(room[1]);
                    if (health + healingPotion <= 100) {
                        health = health + healingPotion;
                        System.out.println("You healed for " + healingPotion + " hp.");
                        System.out.println("Current health: " + health + " hp.");
                    } else {
                        int missingHealth = 100 - health;
                        health = 100;
                        System.out.println("You healed for " + missingHealth + " hp.");
                        System.out.println("Current health: 100 hp.");
                    }
                    break;
                case "chest":
                    int moneyFound = Integer.parseInt(room[1]);
                    bitcoins += moneyFound;
                    System.out.println("You found " + moneyFound + " bitcoins.");
                    break;
                default:
                    int monsterAttack = Integer.parseInt(room[1]);
                    if (health - monsterAttack > 0) {
                        health -= monsterAttack;
                        System.out.println("You slayed " + itemOrMonster + ".");
                    } else {
                        System.out.println("You died! Killed by " + itemOrMonster + ".");
                        System.out.printf("Best room: %d%n", i + 1);
                        areAlive = false;
                    }
                    break;
            }
        }
        if (areAlive) {
            System.out.println("You've made it!");
            System.out.println("Bitcoins: " + bitcoins);
            System.out.println("Health: " + health);
        }
    }
}
