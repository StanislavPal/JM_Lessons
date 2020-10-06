package Lesson7;

import java.io.BufferedReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lesson_7_2_12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8).useDelimiter("[[^a-zA-Z0-9а-яА-Я]\\s\\n]");
        Stream<String> stream = scanner.tokens();
        stream
                .sorted()
                .map(x->x.toLowerCase())
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().sorted(Map.Entry.comparingByKey())
                .limit(10)
                .forEach(s->System.out.print(s + " "));

//        try (final InputStream is = A.class.getResourceAsStream("data.txt");
//             final Reader r = new InputStreamReader(is, StandardCharsets.UTF_8);
//             final BufferedReader br = new BufferedReader(r);
//             final Stream<String> lines = br.lines()) {

        List<Student> students = Arrays.asList(
                new Student("Alex", Speciality.Physics, 1),
                new Student("Rika", Speciality.Biology, 4),
                new Student("Julia", Speciality.Biology, 2),
                new Student("Steve", Speciality.History, 4),
                new Student("Mike", Speciality.Finance, 1),
                new Student("Hinata", Speciality.Biology, 2),
                new Student("Richard", Speciality.History, 1),
                new Student("Kate", Speciality.Psychology, 2),
                new Student("Sergey", Speciality.ComputerScience, 4),
                new Student("Maximilian", Speciality.ComputerScience, 3),
                new Student("Tim", Speciality.ComputerScience, 5),
                new Student("Ann", Speciality.Psychology, 1)
        );

        students.stream()
                .collect(Collectors.groupingBy(Student::getYear))
                .entrySet().forEach(System.out::println);


    }
}


class Student {
    private String name;
    private Speciality speciality;
    private int year;

    public Student(String name, Speciality speciality, int year) {
        this.name = name;
        this.speciality = speciality;
        this.year = year;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return name + ": " + speciality + " " + year;
    }
}

enum Speciality {
    Biology, ComputerScience, Economics, Finance,
    History, Philosophy, Physics, Psychology
}
