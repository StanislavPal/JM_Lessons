package Lesson5;



import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.function.*;

public class Lesson_5_2_8 {
    public static void main(String[] args) throws IOException {
       print(System.in, System.out);

    }

    public static void print(InputStream inputStream, OutputStream outputStream) throws IOException {
        int read;
        while(( read = inputStream.read() ) != -1) {
            if((read % 2) == 0) {
                outputStream.write(read);
            }
        }
        outputStream.flush();
    }
}
