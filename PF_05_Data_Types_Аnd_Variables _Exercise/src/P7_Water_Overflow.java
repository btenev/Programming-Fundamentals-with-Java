import java.util.Scanner;

public class P7_Water_Overflow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int waterTankCapacity = 255;
        int totalAddedWater = 0;

        for (int i = 1; i <= n; i++) {
            int addedWater = Integer.parseInt(scanner.nextLine());

            if (waterTankCapacity >= totalAddedWater + addedWater) {
                totalAddedWater += addedWater;
            } else {
                System.out.println("Insufficient capacity!");
            }
        }
        System.out.println(totalAddedWater);
    }
}
