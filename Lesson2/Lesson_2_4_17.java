package Lesson2;

import java.util.Arrays;

public class Lesson_2_4_17 {

    public static void main(String[] args) {
        int[] arr = {-7, 1, 2, 3, 4, 5, 6, 7, 8, 9};

        printOddNumbers(arr);

    }

    public static void printOddNumbers(int[] arr) {
        boolean bFirst = true;

        for (int i : arr) {
            if (Math.abs(i % 2) == 1) {
                if (bFirst) {
                    System.out.print(i);
                    bFirst = false;
                } else {
                    System.out.print("," + i);
                }
            }
        }
        System.out.println();
    }

}
