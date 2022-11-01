import java.util.*;

public class P7_Student_Academy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, List<Double>> diary = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String studentName =  scanner.nextLine();
            double grade = Double.parseDouble(scanner.nextLine());

            if (!diary.containsKey(studentName)) {
                diary.put(studentName, new ArrayList<>());
            }
            diary.get(studentName).add(grade);
        }

        Map<String, Double> diaryAverage = new LinkedHashMap<>();
        for (Map.Entry<String, List<Double>> entry : diary.entrySet()) {
            double average = entry.getValue().stream().mapToDouble(Double::doubleValue).average().getAsDouble();
            if (average >= 4.50) {
                diaryAverage.put(entry.getKey(), average);
            }
        }
        diaryAverage.entrySet().stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .forEach(entry -> System.out.printf("%s -> %.2f%n", entry.getKey(), entry.getValue()));
    }
}
