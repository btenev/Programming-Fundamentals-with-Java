import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class P5_Nether_Realms {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> demonNames = Arrays.stream(scanner.nextLine().split("[, ]+"))
                .sorted().collect(Collectors.toList());
        String regexHealth = "([^\\d+\\-*/.])";
        Pattern health = Pattern.compile(regexHealth);
        String regexDamage = "(-?[0-9]+\\.?[0-9]*)";
        Pattern damage = Pattern.compile(regexDamage);
        String additionalSymbols = "([*/])";
        Pattern symbols = Pattern.compile(additionalSymbols);

        for (String demonName : demonNames) {
            Matcher healthToMatch = health.matcher(demonName);
            int healthTotal = 0;
            while (healthToMatch.find()){
                healthTotal += healthToMatch.group(1).charAt(0);
            }
            Matcher damageToMatch = damage.matcher(demonName);
            double damageTotal = 0;
            while (damageToMatch.find()) {
                damageTotal += Double.parseDouble(damageToMatch.group(1));
            }
            Matcher symbolToMatch = symbols.matcher(demonName);
            while (symbolToMatch.find()) {
                if (symbolToMatch.group(1).equals("*")) {
                    damageTotal *= 2;
                } else {
                    damageTotal /= 2;
                }
            }
            System.out.printf("%s - %d health, %.2f damage%n", demonName, healthTotal, damageTotal);
        }
    }
}
