package Lesson2;

public class Lesson_2_2_8_2 {
    public static void main(String[] args) {
        System.out.println("f8 " + isPowerOfTwo(8));
        System.out.println("9 " + isPowerOfTwo(9));
        System.out.println("7 " + isPowerOfTwo(7));
        System.out.println("16 " + isPowerOfTwo(16));
    }

    public static boolean isPowerOfTwo(int value) {

        int i = Math.abs(value);
        return (i != 0) && ((i & (i-1)) == 0);

    }

}
