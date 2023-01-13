package PF_4;

import java.util.*;

public class P3_Heroes_Of_Code_And_Logic_VII {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, ArrayList<Integer>> heroDatabase = new LinkedHashMap<>();
        for (int i = 1; i <= n; i++) {
            String[] tokens = scanner.nextLine().split(" ");
            String name = tokens[0];
            int hp = Integer.parseInt(tokens[1]);
            int mp = Integer.parseInt(tokens[2]);

            heroDatabase.put(name, new ArrayList<>());
            heroDatabase.get(name).add(hp);
            heroDatabase.get(name).add(mp);
        }
        String instruction = scanner.nextLine();
        while (!instruction.equals("End" )) {
            String[] moreTokens = instruction.split(" - ");
            String command = moreTokens[0];
            String heroName = moreTokens[1];
            switch (command) {
                case "CastSpell":
                    int mpCost = Integer.parseInt(moreTokens[2]);
                    String spellName = moreTokens[3];
                    if (heroDatabase.get(heroName).get(1) - mpCost >= 0) {
                        int manaLeft = heroDatabase.get(heroName).get(1) - mpCost;
                        heroDatabase.get(heroName).set(1, manaLeft);
                        System.out.println(heroName + " has successfully cast " + spellName + " and now has "
                                + manaLeft + " MP!");
                    } else {
                        System.out.println(heroName + " does not have enough MP to cast " + spellName + "!");
                    }
                    break;
                case "TakeDamage":
                    int damage = Integer.parseInt(moreTokens[2]);
                    String attacker = moreTokens[3];
                    if (heroDatabase.get(heroName).get(0) - damage > 0) {
                        int hpLeft = heroDatabase.get(heroName).get(0) - damage;
                        heroDatabase.get(heroName).set(0, hpLeft);
                        System.out.println(heroName + " was hit for " + damage + " HP by " + attacker + " and now has "
                                + hpLeft + " HP left!");
                    } else {
                        heroDatabase.remove(heroName);
                        System.out.println(heroName + " has been killed by " + attacker + "!");
                    }
                    break;
                case "Recharge":
                    int rechargeAmount = Integer.parseInt(moreTokens[2]);
                    if (heroDatabase.get(heroName).get(1) + rechargeAmount > 200) {
                        int recoveredMP = 200 - heroDatabase.get(heroName).get(1);
                        heroDatabase.get(heroName).set(1, 200);
                        System.out.println(heroName + " recharged for " + recoveredMP + " MP!");
                    } else {
                        int newAmount = heroDatabase.get(heroName).get(1) + rechargeAmount;
                        heroDatabase.get(heroName).set(1, newAmount);
                        System.out.println(heroName + " recharged for " + rechargeAmount + " MP!");
                    }
                    break;
                case "Heal":
                    int recoverHP = Integer.parseInt(moreTokens[2]);
                    if (heroDatabase.get(heroName).get(0) + recoverHP > 100) {
                        int recoveredHp = 100 - heroDatabase.get(heroName).get(0);
                        heroDatabase.get(heroName).set(0, 100);
                        System.out.println(heroName + " healed for " + recoveredHp + " HP!");
                    } else {
                        int newAmountHp = heroDatabase.get(heroName).get(0) + recoverHP;
                        heroDatabase.get(heroName).set(0, newAmountHp);
                        System.out.println(heroName + " healed for " + recoverHP + " HP!");
                    }
                    break;
            }
            instruction = scanner.nextLine();
        }
            heroDatabase.entrySet().stream().sorted((e1, e2) ->{
            int result = e2.getValue().get(0).compareTo(e1.getValue().get(0));
            if (result == 0) {
                result = e1.getKey().compareTo(e2.getKey());
            }
            return  result;
        }).forEach(entry -> {System.out.println(entry.getKey());
            System.out.println("HP: " + entry.getValue().get(0));
            System.out.println("MP: " + entry.getValue().get(1));
        });
/*        heroDatabase.entrySet().stream().sorted((e1, e2) -> {
            int result = Integer.compare(e2.getValue().get(0), e1.getValue().get(0));
            if (result == 0) {
                result = e1.getKey().compareTo(e2.getKey());   // Имаме Integer.compare(), Double.compare()
            }
            return result;
        }).forEach(entry -> {System.out.println(entry.getKey());
            System.out.println("HP: " + entry.getValue().get(0));
            System.out.println("MP: " + entry.getValue().get(1));
        });   */
       /* heroDatabase.entrySet().stream()
                .sorted(Map.Entry.comparingByValue((e1, e2) -> e2.get(0).compareTo(e1.get(0)))); */


    }
}
