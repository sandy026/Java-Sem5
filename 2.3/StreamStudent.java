//2part
import java.util.*;
import java.util.stream.*;

class Student {
    String name;
    double marks;

    public Student(String name, double marks) {
        this.name = name;
        this.marks = marks;
    }

    @Override
    public String toString() {
        return name + " - Marks: " + marks;
    }
}

public class StreamStudent {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
            new Student("Amit", 85.5),
            new Student("Neha", 72.0),
            new Student("Kiran", 90.2),
            new Student("Ravi", 67.5),
            new Student("Pooja", 78.0)
        );

        System.out.println("Students scoring above 75%, sorted by marks:");
        students.stream()
                .filter(s -> s.marks > 75)
                .sorted((s1, s2) -> Double.compare(s2.marks, s1.marks)) // descending order
                .map(s -> s.name)
                .forEach(System.out::println);
    }
}
