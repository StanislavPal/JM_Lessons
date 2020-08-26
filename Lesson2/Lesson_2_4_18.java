package Lesson2;

import java.util.Arrays;

public class Lesson_2_4_18 {

    public static void main(String[] args) {
        int[] a1 = {6};
        int[] a2 = {1,3,5};
        int[] mergedArray = mergeArrays(a1, a2);
        System.out.println(Arrays.toString(mergedArray));
    }

    public static int[] mergeArrays(int[] a1, int[] a2) {
        int maxLength = a1.length + a2.length;
        int[] resArr = new int[maxLength];
        int m = 0;
        int n = 0;

        for (int i = 0; i < maxLength; i++) {
            if ((m < a1.length)  && (n < a2.length)) {
                if (a1[m] < a2[n]) {
                    resArr[i] = a1[m];
                    m++;
                } else {
                    resArr[i] = a2[n];
                    n++;
                }
            } else if (m < a1.length) {
                resArr[i] = a1[m];
                m++;
            } else {
                resArr[i] = a2[n];
                n++;
            }
        }
        return resArr;
    }

}
