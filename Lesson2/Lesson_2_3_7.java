package Lesson2;

public class Lesson_2_3_7 {
    public static void main(String[] args) {

        String se = "A12";

        String s1 = "A" + ('\t' + '\u0003');
        String s2 = 'A' + '1' + "2";
        String s3 = "A" + 12;
        String s4 = 'A' + "12";

        System.out.println("s1 = " + s1 + "; " + se.equals(s1));
        System.out.println("s2 = " + s2 + "; " + se.equals(s2));
        System.out.println("s3 = " + s3 + "; " + se.equals(s3));
        System.out.println("s4 = " + s4 + "; " + se.equals(s4));

        String s5 = 'A' + "";
        s5 += '1';
        s5 += '2';
        String s6 = "" + 'A';
        s6 += '1';
        s6 += '2';
        String s7 = "" + 'A' + '1' + '2';
        String s8 = 'A' + '1' + '2' + "";

        System.out.println("s5 = " + s5 + "; " + se.equals(s5));
        System.out.println("s6 = " + s6 + "; " + se.equals(s6));
        System.out.println("s7 = " + s7 + "; " + se.equals(s7));
        System.out.println("s8 = " + s8 + "; " + se.equals(s8));

    }
}
