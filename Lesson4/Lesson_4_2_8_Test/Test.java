package Lesson4.Lesson_4_2_8_Test;

import java.util.logging.Logger;

public class Test {
    private static Logger logger = Logger.getLogger(Test.class.getName());

    public static void main(String[] args) {

        logger.info("Мы перед вызовом метода");
        System.out.println( testException1(true) );
        System.out.println("Мы после вызова метода");
    }

    private static void rekursiya(String s, long x) {
        double dd = 15d;
        String ss = s + "a";
        long i = 64 + x;
        if (x < 100_000) {
            rekursiya("a", x+1);
        }
    }

    public static String testException1 (boolean bBreak) {
        while(true) {
            try ( Resourse resourse = new Resourse(false) ){
                System.out.println("Мы в блоке трай");
                //rekursiya("r", 0);
                if(bBreak) {
                    return "foo";
                }
                testTrowException();
                //return "foo";
             }catch (RobotException e) {
                break;
            }
        }
        System.out.println("Мы за циклом в методе");
        return "bar";
    }

    public static void testTrowException () {
        throw new RobotException("testTrowException");
    }
}
