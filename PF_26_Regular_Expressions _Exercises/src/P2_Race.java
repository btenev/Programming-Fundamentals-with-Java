import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class P2_Race {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> racers = Arrays.stream(scanner.nextLine().split(", ")).collect(Collectors.toList());
        Map<String, Integer> racerDistances = new LinkedHashMap<>();
        racers.forEach(racer -> racerDistances.put(racer, 0));

        String regexLetters = "[A-Za-z]";
        Pattern patternName = Pattern.compile(regexLetters);

        String regexDigits = "[0-9]";
        Pattern patternDistance = Pattern.compile(regexDigits);

        String input = scanner.nextLine();
        while (!input.equals("end of race")) {
            StringBuilder name = new StringBuilder();
            Matcher nameToMatch = patternName.matcher(input);

            while (nameToMatch.find()) {
                name.append(nameToMatch.group());
            }

            int sum = 0;
            Matcher distanceToMatch = patternDistance.matcher(input);

            while (distanceToMatch.find()) {
                sum += Integer.parseInt(distanceToMatch.group());
            }
            String racer = name.toString();
            if (racerDistances.containsKey(racer)) {
                racerDistances.put(racer, racerDistances.get(racer) + sum);
            }

            input = scanner.nextLine();
        }
//        List<String>threeNames = racerDistances.entrySet().stream()
//                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue())).limit(3)
//                .map(entry -> entry.getKey()).collect(Collectors.toList());
        List<String> threeNames = racerDistances.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(3)
                .map(entry -> entry.getKey())
                .collect(Collectors.toList());
        System.out.println("1st place: " + threeNames.get(0));
        System.out.println("2nd place: " + threeNames.get(1));
        System.out.println("3rd place: " + threeNames.get(2));
    }
}
