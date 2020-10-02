package Lesson6;

public class Lesson_6_1_11 {
    public static void main(String[] args) {

    }

    public static class Box<T> {
        private T object;

        public static <E> Box<E> getBox() {
            return new Box<>();
        }
    }
}
