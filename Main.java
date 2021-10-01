package homework9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("Андрей", Arrays.asList(
                new Course("Робототехника"),
                new Course("Физика"),
                new Course("Химия")
        )));

        studentList.add(new Student("Антон", Arrays.asList(
                new Course("Робототехника"),
                new Course("Математика")
        )));

        studentList.add(new Student("Анна", Arrays.asList(
                new Course("Математика"),
                new Course("Физика"),
                new Course("Химия"),
                new Course("Биология")
        )));

        studentList.add(new Student("Елена", Arrays.asList(
                new Course("Математика"),
                new Course("Физика"),
                new Course("Химия"),
                new Course("Биология"),
                new Course("Механика")
        )));

        System.out.println(studentList.stream()
                .map(s -> s.getCourseList())
                .flatMap(c -> c.stream())
                .map(n -> n.getName())
                .collect(Collectors.toSet())
        );

        System.out.println(studentList.stream()
                .sorted((s1, s2) -> s2.getCourseList().size() - s1.getCourseList().size())
                .limit(2)
                .collect(Collectors.toList())
        );

        Course course = new Course("Биология");
        System.out.println(studentList.stream()
                .filter(c -> c.getCourseList().contains(course))
                .collect(Collectors.toList())
        );
    }
}
