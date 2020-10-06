package Lesson7;

import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Lesson_7_2_12_Scanner_NotValidate {
    public static void main(String[] args) {
        new Scanner(System.in, "UTF-8")
                .useDelimiter("[^a-zA-Zа-яА-Я0-9]")
                .tokens()
                .map(s -> s.toLowerCase())
                .collect( Collectors.groupingBy( Function.identity(), Collectors.counting() ) )
                .entrySet()
                .stream()
                .sorted( Map.Entry.<String, Long>comparingByValue().reversed().thenComparing( Map.Entry.comparingByKey()) )
                .limit(10)
                .forEach(e -> System.out.println(e.getKey()) );
    }
}
