package Lesson5;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;

public class Lesson_5_3_10 {
    public static void main(String[] args) throws IOException {
        Writer writer = new OutputStreamWriter(System.out, StandardCharsets.US_ASCII);

        int read;
        while ((read = System.in.read()) >= 0) {
            writer.write(read);
            writer.flush();
        }
    }
}


