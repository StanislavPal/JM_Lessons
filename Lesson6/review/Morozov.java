package Lesson6.review;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class Morozov {
    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(1, 2, 3);
        Gen<Integer> gen = new Gen();
        gen.m(integerList);
    }

    static class Gen<T> {
        void m(Collection<T> collection) {
            System.out.println("=1=");
            for (T s : collection) {
                System.out.println(s);
            }
        }

        void m(List<String> list) {
            System.out.println("=2=");
            for (String s : list) {
                System.out.println(s);
            }
        }
    }
}