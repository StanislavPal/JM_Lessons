package Lesson4.Lesson_4_2_8;

public class Test {
    public static void main(String[] args) {
        int i = 0;
        boolean bConnect = false;
        while (i < 10 && !bConnect ) {
            System.out.println("lsdkgj: " + i);
            i++;
            if (i == 7) {
                bConnect = true;
            }
        }

    }
}
