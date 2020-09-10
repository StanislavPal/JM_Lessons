package Lesson2;

import java.math.BigDecimal;

public class review {
    public static void main(String[] args) {

        long longBefore = Long.MAX_VALUE;
        float f = longBefore;
        long longAfter = (long) f;

        System.out.println("         long до: " + longBefore + " : " + Long.toBinaryString(longBefore) );
        System.out.println("   float из long: " + f + " : " + Integer.toBinaryString( Float.floatToIntBits(f) ));
        System.out.println("long после флоат: " + longAfter + " : " + Long.toBinaryString(longAfter) );

        System.out.println("Сравнение через BigDicimal: " + new BigDecimal(longBefore).compareTo( new BigDecimal(f) ));
        System.out.println(" long -> BigDicimal: " + new BigDecimal(longBefore));
        System.out.println("float -> BigDicimal: " + new BigDecimal(f) );

        short shortBefore = -100;
        char  c = (char) shortBefore;
        short shortAfter = (short) (c);
        System.out.printf("%d, %d, %d\n", shortBefore, (int) c, shortAfter);

        float ff = 9.223372E18f;
        longAfter = (long) ff;
        System.out.println("long после флоат 2: " + longAfter + " : " + Long.toBinaryString(longAfter) );

    }

}
