package Lesson6;

import java.util.*;

public class Lesson_6_2_13 {
    public static void main(String[] args) {
        HashSet<Integer> set1 = new HashSet<>( Arrays.asList(1, 2, 3) );
        HashSet<Integer> set2 = new HashSet<>( Arrays.asList(0, 1, 2) );

        HashSet<Integer> result = (HashSet<Integer>) symmetricDifference(set1, set2);
        System.out.println(result);
    }


    public static <T> Set<T> symmetricDifference(Set<? extends T> set1, Set<? extends T> set2) {
        Set<T> union = new LinkedHashSet<>();
        union.addAll(set1);
        union.addAll(set2);

//        Set<T> intersection = new LinkedHashSet<>();
//        for (T t : set1) {
//            if(set2.contains(t)) {
//                intersection.add(t);
//            }
//        }
        Set<T> intersection = new LinkedHashSet<>();
        intersection.addAll(set1);
        intersection.retainAll(set2);

//        Iterator<T> it = intersection.iterator();
//        while( it.hasNext() ) {
//            T t = it.next();
//            if(union.contains(t)) {
//                union.remove(t);
//            }
//        }
        union.removeAll(intersection);

        return (Set<T>) union;
    }

}
