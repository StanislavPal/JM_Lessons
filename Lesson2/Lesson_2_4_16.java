package Lesson2;

import java.util.Arrays;

public class Lesson_2_4_16 {

    public static void main(String[] args) {

        System.out.println(" 8: " + Arrays.toString( evenArray(8) ));
        System.out.println("11: " + Arrays.toString( evenArray(11) ));

    }

    public static int[] evenArray(int number) {
        int endOfArray = number / 2;
        int[] arr = new int[endOfArray];

        for (int i = 0; i < endOfArray; i++) {
            arr[i] = (i + 1) * 2;
        }
        return arr;

    }

}
