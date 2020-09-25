package Lesson4.Lesson_4_2_8_Test;

public class Resourse implements AutoCloseable{
    private static boolean bThrow;

    public Resourse (Boolean b) {
        bThrow = b;
    }

    private void throwException() {
        if (bThrow) {
            throw new RobotException("close");
        }
    }

    private void rekursiya(String s, long x) {
        String ss = s + "a";
        long i = 64 + x;
        if (x < 100_000) {
            rekursiya("a", x+1);
        }
     }

    @Override
    public void close() {
        if(true) {throwException();}
        else {rekursiya("e", 0);}
        System.out.println("Ресурс закрыт!");
    }
}
