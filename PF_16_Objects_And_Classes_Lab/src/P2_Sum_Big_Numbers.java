import java.math.BigInteger;
import java.util.Scanner;

public class P2_Sum_Big_Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        BigInteger one = new BigInteger(scanner.nextLine());
        BigInteger two = new BigInteger(scanner.nextLine());

        BigInteger result = one.add(two);
        System.out.println(result);
    }
}
