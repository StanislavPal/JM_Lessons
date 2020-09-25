package Lesson5;

import java.io.IOException;

public class Lesson_5_3_9 {
    public static void main(String[] args) throws IOException {
        int read;
        while (( read = System.in.read() ) >= 0) {
            System.out.println("b = " + read);
        }
    }
}
