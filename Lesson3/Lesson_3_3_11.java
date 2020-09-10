package Lesson3;

public class Lesson_3_3_11 {
    public static void main(String[] args) {

    }

    public static class Cat {
        public void sayHello() {
            System.out.println("Мяу!");
        }
    }

    public static class Dog {
        public void sayHello() {
            System.out.println("Гав!");
        }

        public void catchCat(Cat cat) {
            System.out.println("Кошка поймана!");
            sayHello();
            cat.sayHello();
        }

    }

}

