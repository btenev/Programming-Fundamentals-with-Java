import java.util.*;

public class P6_Courses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String, ArrayList<String>> coursesStudents = new LinkedHashMap<>();
        while (!input.equals("end")) {
            String[] tokens = input.split(" : ");
            String course = tokens[0];
            String studentName = tokens[1];
            coursesStudents.putIfAbsent(course, new ArrayList<>());
            coursesStudents.get(course).add(studentName);

            input = scanner.nextLine();
        }
        coursesStudents.entrySet().stream()
                .sorted((e1,e2) -> Integer.compare(e2.getValue().size(),e1.getValue().size()))
                .forEach(entry -> {
                    System.out.println(entry.getKey() + ": " + entry.getValue().size());
                    List<String> students = entry.getValue();
                    students.stream().sorted().forEach(studentName -> System.out.println("-- " + studentName));
                });
    }
}
