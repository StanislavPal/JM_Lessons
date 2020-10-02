package Lesson6;

import java.util.Objects;
import java.util.Optional;

public class Lesson_6_1_12 {
    public static void main(String[] args) {
        Pair<Integer, String> pair = Pair.of(1, null);
        Integer i = pair.getFirst(); // 1
        String s = pair.getSecond(); // "hello"
        Pair<Integer, String> pair2 = Pair.of(2, null);
        boolean mustBeTrue = pair.equals(pair2); // true!
        boolean mustAlsoBeTrue = pair.hashCode() == pair2.hashCode(); // true!
        Optional optional = Optional.of(1);
        System.out.println(i);
        System.out.println(s);
        System.out.println(mustBeTrue);
        System.out.println(mustAlsoBeTrue);
        System.out.println(pair);
    }

    public static class Pair<T, X> {
        private T first;
        private X second;

        private Pair(T first, X second) {
            this.first = first;
            this.second = second;
        }

        public T getFirst() {
            return first;
        }

        public X getSecond() {
            return second;
        }

        public static <T, X>Pair<T, X> of(T first, X second) {
            return new Pair<>(first, second);
        }

        @Override
        public boolean equals(Object obj){
            if (this == obj) {
                return true;
            }

            if(obj == null) {
                return false;
            }

            if (!(obj instanceof Pair)) {
                return false;
            }

            Pair<?, ?> other = (Pair<?, ?>) obj;
            return Objects.equals(first, other.first) &&
                    Objects.equals(second, other.second);
        }

        @Override
        public int hashCode() {
            int result = 17;
            result = result*31 + Objects.hashCode(first);
            result = result*31 + Objects.hashCode(second);
            return result;
        }
    }
}


