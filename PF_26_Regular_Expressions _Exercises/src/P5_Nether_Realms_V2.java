import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class P5_Nether_Realms_V2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> demonNames = Arrays.stream(scanner.nextLine().split("[, ]+"))
                                .sorted().collect(Collectors.toList());
        String regexHealth = "[^\\d+\\-*/.]";
        Pattern health = Pattern.compile(regexHealth);

        String regexDamage = "-?[0-9]+\\.?[0-9]*";
        Pattern damage = Pattern.compile(regexDamage);

        String additionalSymbols = "[*/]";
        Pattern symbols = Pattern.compile(additionalSymbols);

        Map<String, List<Double>> demonDataBase = new LinkedHashMap<>();

        for (int i = 0; i < demonNames.size(); i++) {
            String currentDemon = demonNames.get(i);

            Matcher healthToMatch = health.matcher(currentDemon);
            String healthSymbols = findSymbols(currentDemon, healthToMatch);

            demonDataBase.put(currentDemon, new ArrayList<>());

            double calculatedHealth = calculateHealth(healthSymbols);
            demonDataBase.get(currentDemon).add(calculatedHealth);

            Matcher damageToMatch = damage.matcher(currentDemon);
            Matcher symbolsToMatch = symbols.matcher(currentDemon);
            double totalDamage = calculateDamage(currentDemon, damageToMatch, symbolsToMatch);
            demonDataBase.get(currentDemon).add(totalDamage);
        }

        demonDataBase.entrySet().stream()
        .forEach(entry -> System.out.printf("%s - %.0f health, %.2f damage%n"
                , entry.getKey(),entry.getValue().get(0), entry.getValue().get(1)));
    }

    private static String findSymbols(String name, Matcher health) {
        StringBuilder sb = new StringBuilder();
        while (health.find()) {
            sb.append(health.group());
        }
        return sb.toString();
    }

    private static double calculateDamage(String name, Matcher damage, Matcher symbols) {
        double totalDamage = 0;
        while (damage.find()) {
           totalDamage += Double.parseDouble(damage.group());
        }
        while (symbols.find()) {
            String symbol = symbols.group();
            if (symbol.equals("*")) {
                totalDamage *= 2;
            } else if (symbol.equals("/")) {
                totalDamage /= 2;
            }
        }

        return totalDamage;
    }

    private static double calculateHealth(String name) {
        double totalHealth = 0;
        for (int i = 0; i < name.length(); i++) {
            char currentSymbol = name.charAt(i);
            totalHealth += currentSymbol;
        }
        return totalHealth;
    }
}
