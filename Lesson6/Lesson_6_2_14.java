package Lesson6;

import java.util.*;

public class Lesson_6_2_14 {
    public static void main(String[] args) {
        List<Integer> arr = new LinkedList<>();

        Scanner scanner = new Scanner(System.in);
        while( scanner.hasNextInt() ) {
            arr.add( scanner.nextInt() );
        }
        scanner.close();

        Iterator<Integer> iterator = arr.iterator();
        int i = 0;
        while (iterator.hasNext()) {
            iterator.next();
            if ((i % 2) == 0) {
                iterator.remove();
            }
            i++;
        }

        ListIterator listIterator = arr.listIterator(arr.size());
        while(listIterator.hasPrevious()) {
            System.out.print( listIterator.previous() + " ");
        }
    }
}
