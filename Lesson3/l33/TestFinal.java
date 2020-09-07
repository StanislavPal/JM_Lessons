package Lesson3.l33;

import java.math.BigInteger;

public final class TestFinal {
    public static void main(String[] args) {
//        Math m = new Math(); //Нельзя вызвать конструктор с модификатором private. Нельзя создать объект класса


        System.out.println( TestFinal1.getTest() );
        TestFinal1.setTest(15);
        System.out.println( TestFinal1.getTest() );
        BigInteger.ONE.ONE.ONE.valueOf(10).toString();
    }

}

final class TestFinal1 {
    private final int testFinal;
    private static final int test;

    {
        testFinal = 5;
    }

    static {
        test = 5;
    }


    public static int getTest() {
        return test;
    }

    public static void setTest(int test) {
//        TestFinal1.test = test;
    }

}

class TestFinal2 {
    private final int testFinal;

    TestFinal2(int testFinal) {
        this.testFinal = testFinal;
    }
}

class TestFinal3 {
//    private final int testFinal;

}
