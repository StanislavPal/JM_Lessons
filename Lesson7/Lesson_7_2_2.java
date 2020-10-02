package Lesson7;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Lesson_7_2_2 {
    public static void main(String[] args) {
//        int sum =
                IntStream.iterate(1, n -> n + 1)
//                .filter(n -> n % 5 == 0 && n % 2 != 0)
                .limit(10)
//                .map(n -> n * n)
//                .sum();
                .forEach(System.out::println);

//        System.out.println( sum );

        IntStream.of(120, 410, 85, 32, 314, 12, 199)
                .filter(x -> x < 300)
                .map(x -> x + 11)
                .limit(3)
                .forEach(System.out::println);

/*
        Это код Шрёдингера. Он может нормально выполниться и показать 1000000,
        может выполниться и показать 869877, а может и упасть с ошибкой
        Exception in thread "main" ArrayIndexOutOfBoundsException
*/
        final List<Integer> ints = new ArrayList<>();
        IntStream.range(0, 1_000_000)
//                .parallel() // <- включает режим кота
                .forEach(i -> ints.add(i));
        System.out.println(ints.size());


        //7.2.10
        int d = 123456;
        System.out.printf(" mid(%d) = %d\n", d, mid(d) );
        pseudoRandomStream(13).limit(20).forEach(System.out::println);
    }

    public static IntStream pseudoRandomStream(int seed) {
        return IntStream.iterate(seed, n -> (n * n) / 10 % 1000 );
    }

    public static int mid(int i) {
        return (i/10)%1000;
    }

}
