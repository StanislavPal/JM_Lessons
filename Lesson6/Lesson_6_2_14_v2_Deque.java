package Lesson6;

import java.util.*;

public class Lesson_6_2_14_v2_Deque {
    public static void main(String[] args) {
        Deque<Integer> arr = new LinkedList<>();

        Scanner scanner = new Scanner(System.in);

        int i = 0;
        while( scanner.hasNextInt() ) {
            if ((i % 2) != 0) {
                arr.addFirst( scanner.nextInt() );
            } else {
                scanner.next();
            }
            i++;
        }
        scanner.close();

        arr.forEach(System.out::println);
        for (Integer integer : arr) {
            System.out.print(integer + " ");
        }
    }
}
