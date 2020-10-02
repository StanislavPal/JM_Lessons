package Lesson2;

import java.math.BigDecimal;
import java.util.Scanner;

public class Review {
    public static void main(String[] args) {
//        System.out.println(Integer.MAX_VALUE);
//        byte[] arr = new byte[2_140_200_000];
//        Scanner scanner = new Scanner(System.in);
//        scanner.next();

        char c = 0x8000;
        System.out.println(c);
        char cc = '\u8000';
        System.out.println(cc);

//        short s = (short) c;
//        System.out.println(s + "\t" + Integer.toBinaryString(s));
//        System.out.println(c + "\t" + Integer.toBinaryString(c + 32767) + " = " + (c + 32767));
//        System.out.println(c + "\t" + Integer.toBinaryString( (short) c));
//
//        c = (char) s;
//        System.out.println(s + "\t" + Integer.toBinaryString(s));
//        System.out.println(c + "\t" + Integer.toBinaryString(c + 32767) + " = " + (c + 32767));
//        System.out.println(c + "\t" + Integer.toBinaryString( (short) c));
//
        long l = Long.MAX_VALUE;
        float f = l;
        System.out.println("Long.MAX_VALUE: " + l);
        System.out.println("float: " + f);
        System.out.println("Long (2): " + Long.toBinaryString(l));
        System.out.println("float (2): " + Integer.toBinaryString( Float.floatToIntBits(f) ) );
        System.out.println();

        //Способ, которые используют менторы
        long longAfterFloat = (long) f;
        System.out.println("Long after float: " + longAfterFloat);
        System.out.println("l == longAfterFloat : " + (l == longAfterFloat));
        System.out.println();

        //мой способ
        BigDecimal bd = BigDecimal.valueOf(f);
        System.out.println("BigDecimal from float: " + bd.toPlainString());
        System.out.println("bd == l : " + ( bd.compareTo( BigDecimal.valueOf(l) ) == 0 ? true : false));
        System.out.println();

        f = Float.MAX_VALUE;
        longAfterFloat = (long) f;
        System.out.println("float: " + f);
        System.out.println("float (2): " + Integer.toBinaryString( Float.floatToIntBits(f) ) );
        bd = BigDecimal.valueOf(f);
        System.out.println("BigDecimal from float: " + bd.toPlainString());
        System.out.println("Long after float: " + longAfterFloat);
        System.out.println("l == longAfterFloat : " + (l == longAfterFloat));

        f = l;
        for (long i = -1_000_000_000_000L; i < 1_000_000_000; i += 1_000_000_000) {
            //f += i;
            System.out.println("float: " + (f + i) + " : " + i);
            System.out.println("float (2): " + Integer.toBinaryString( Float.floatToIntBits(f + i) ) );
        }

    }
}
