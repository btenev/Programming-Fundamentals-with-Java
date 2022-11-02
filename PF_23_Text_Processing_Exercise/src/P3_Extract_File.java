import java.util.Scanner;

public class P3_Extract_File {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] pathway = scanner.nextLine().split("\\\\");
        String lastData = pathway[pathway.length -1];
        String[] tokens = lastData.split("\\.");
        String fileName =  tokens[0];
        String extension =  tokens[1];

        System.out.println("File name: " + fileName);
        System.out.println("File extension: " + extension);
    }
}
