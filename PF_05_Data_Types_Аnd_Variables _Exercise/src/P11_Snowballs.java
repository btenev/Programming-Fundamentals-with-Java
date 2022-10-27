import java.util.Scanner;

public class P11_Snowballs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfSnowball = Integer.parseInt(scanner.nextLine());
        double maxSnowballValue = Double.MIN_VALUE;
        int bestSnowballSnow = 0;
        int bestSnowballTime = 0;
        int bestSnowballQuality = 0;

        for (int i = 1; i <= numberOfSnowball; i++) {
            int snowballSnow = Integer.parseInt(scanner.nextLine());
            int snowballTime = Integer.parseInt(scanner.nextLine());
            int snowballQuality = Integer.parseInt(scanner.nextLine());

            int result = snowballSnow / snowballTime;
            double snowballValue = Math.pow(result, snowballQuality);
            if (snowballValue > maxSnowballValue) {
                maxSnowballValue = snowballValue;
                bestSnowballSnow = snowballSnow;
                bestSnowballTime = snowballTime;
                bestSnowballQuality = snowballQuality;
            }
        }
        System.out.printf("%d : %d = %.0f (%d)", bestSnowballSnow, bestSnowballTime, maxSnowballValue, bestSnowballQuality);
    }
}
