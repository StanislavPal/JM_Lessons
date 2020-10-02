package Lesson_7;

import java.util.Objects;
import java.util.function.Function;
import java.util.function.Predicate;

public class Lesson_7_1_9 {
    public static void main(String[] args) {
        Predicate<Object> condition = Objects::isNull;
        Function<Object, Integer> ifTrue = obj -> 0;
        Function<CharSequence, Integer> ifFalse = CharSequence::length;
        Function<String, Integer> safeStringLength = ternaryOperator(condition, ifTrue, ifFalse);

    }

    public static <T, U> Function<T, U> ternaryOperator(
            Predicate<? super T> condition,
            Function<? super T, ? extends U> ifTrue,
            Function<? super T, ? extends U> ifFalse) {
        return condition.test() ? (T, U) -> ifTrue.apply(T) : (T, U) -> ifFalse.apply(T);
    }
}
