import java.util.Scanner;

public class PF_06_Calculate_Rectangle_Area {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double length = Double.parseDouble(scanner.nextLine());
        double width = Double.parseDouble(scanner.nextLine());

        double area = getRectangleArea(length, width);
        System.out.printf("%.0f", area);
    }

    private static double getRectangleArea(double length, double width) {
         double rectangleArea = length * width;
         return rectangleArea;
    }
}
