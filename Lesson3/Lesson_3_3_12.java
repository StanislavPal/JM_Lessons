package Lesson3;

public class Lesson_3_3_12 {
    public static void main(String[] args) {

        Human h1 = new Human();
        Human h2 = new Human((byte) 15, "Frank", "Sinatra", "Golf");
        Human h3 = new Human((byte) 27, "Michale", "Jakson");

    }

    public static class Human {
        private static final String EMPTY = "";

        private byte age;
        private String name;
        private String secondName;
        private String favoriteSport;

        public Human() {
            this( (byte) 0, EMPTY, EMPTY, EMPTY);
        }

        public Human(byte age, String name, String secondName) {
            this(age, name, secondName, EMPTY);
        }

        public Human(byte age, String name, String secondName, String favoriteSport) {
            this.age = age;
            this.name = name;
            this.secondName = secondName;
            this.favoriteSport = favoriteSport;
        }

    }
}
