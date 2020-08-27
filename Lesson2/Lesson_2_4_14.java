package Lesson2;

import java.math.BigInteger;
import java.lang.Exception;

public class Lesson_2_4_14 {
    public static void main(String[] args) throws Exception {

        System.out.println( factorial(3).toString() );
        System.out.println( factorial(1).toString() );
        System.out.println( factorial(-5).toString() );
        System.out.println( factorial(150).toString() );

    }

    public static BigInteger factorial(int value) throws Exception {
        if (value < 0) {
            throw new Exception("The number is less than 0");
        } else if (value == 0) {
            return BigInteger.ONE;
        } else {
            return BigInteger.valueOf(value).multiply( factorial(value - 1) );
        }
    }
}
