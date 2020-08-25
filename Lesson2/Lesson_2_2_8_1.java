package Lesson2;

public class Lesson_2_2_8_1 {
    public static void main(String[] args) {
        System.out.println("8 " + isPowerOfTwo(8));
        System.out.println("9 " + isPowerOfTwo(9));
        System.out.println("7 " + isPowerOfTwo(7));
        System.out.println("16 " + isPowerOfTwo(16));
    }

    public static boolean isPowerOfTwo(int value) {

        return Integer.bitCount(Math.abs(value)) == 1;

    }

}
