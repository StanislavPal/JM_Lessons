package Lesson3;

public class Lesson_3_4_2 {
    public static void main(String[] args) {

        Person tom = new Person("Tom");
        tom.display();
        Employee sam = new Employee("Sam", "Oracle");
        sam.display();
        sam.sayID();
        sam = new Employee("Sam", "Oracle");

    }
}
class Person {

    private String name;

    public String getName() { return name; }

    public Person(String name){

        this.name=name;
    }

    public void display(){

        System.out.printf("Person %s \n", name);
    }

    int sum(int a, int b) {
        return a + b;
    }

}

class Employee extends Person{
    private static int id = 0;

    private String company;

    public Employee(String name, String company) {
        super(name);
        this.company = company;
        id++;
    }
    @Override
    public void display(){

        System.out.printf("Employee %s works in %s \n", super.getName(), company);
    }

    @Override
    public int sum(int a, int b) {
        return a + b - 1;
    }

    public void sayID() {
        System.out.println(id);
    }
}