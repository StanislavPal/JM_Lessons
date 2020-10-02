package Lesson6.review;

import java.util.ArrayList;
import java.util.List;

public class StaticTest {
    public static void main(String[] args) {
//        Greet.sayHello("Vasya");
//        Greet.sayHello(123);

//        ArrayList<String> arr = new ArrayList<>();
//        arr.add("foo");
//        arr.add("bar");

        Greet<Character> g = new Greet<>();
        g.sayHello("Vasya");
        g.sayHello(123);
//        g.m(arr);
    }
}

class Greet<T>{
    public <T> void sayHello(T e) {
        System.out.println("Hello " + e);
    }

//    void m(List<T> o){
//        System.out.println("Object");
//    }
//
//    void m(ArrayList<Integer> i){
//        System.out.println("Integer");
//        for (Integer integer : i) {
//            System.out.println(integer);
//        }
//    }
}
