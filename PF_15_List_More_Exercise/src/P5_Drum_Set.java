import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P5_Drum_Set {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double savings = Double.parseDouble(scanner.nextLine());
        List<Integer> drumSetQuality = Arrays.stream(scanner.nextLine().split("\\s+"))
                               .map(Integer::parseInt).collect(Collectors.toList());
        String command = scanner.nextLine();
        List<Integer> qualityInUse = new ArrayList<>(drumSetQuality);
        while (!command.equals("Hit it again, Gabsy!")) {
            int hitPower = Integer.parseInt(command);

            for (int i = 0; i < qualityInUse.size(); i++) {
                int currentDrum = qualityInUse.get(i);
                qualityInUse.set(i,currentDrum - hitPower);
                if(qualityInUse.get(i) < 1) {
                    int originalDrum = drumSetQuality.get(i);
                    int priceToReplace = 3 * originalDrum;
                    if (priceToReplace <= savings) {
                        savings -= priceToReplace;
                        qualityInUse.set(i,drumSetQuality.get(i));
                    } else {
                        qualityInUse.remove(i);
                        drumSetQuality.remove(i);
                        i -= 1;
                    }
                }
            }
            command = scanner.nextLine();
        }
        System.out.println(qualityInUse.toString().replaceAll("[\\[\\],]", ""));
        System.out.printf("Gabsy has %.2flv.%n",savings);
    }
}
