package Lesson6.review;

import java.util.ArrayList;

public class GenericArrayCast {
    public static void main(String[] args) {
        ArrayList<Integer>[] arr = (ArrayList<Integer>[]) new ArrayList[10];
    }
}
