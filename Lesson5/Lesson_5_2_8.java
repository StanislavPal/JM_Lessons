package Lesson5;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Lesson_5_2_8 {
    public static void main(String[] args) {
        System.out.println("-10 mod 2 = " + (-10 % 2));
    }

    public static void print(InputStream inputStream, OutputStream outputStream) throws IOException {
        int read;
        while(( read = inputStream.read() ) != -1) {
            if((read % 2) == 0) {
                outputStream.write( (byte) read);
            }
        }
        outputStream.flush();
    }
}
