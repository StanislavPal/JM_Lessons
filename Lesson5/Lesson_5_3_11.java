package Lesson5;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

public class Lesson_5_3_11 {
    public static void main(String[] args) throws IOException {
        System.out.println(readAsString(System.in, Charset.forName("UTF-8")));
    }

    public static String readAsString(InputStream inputStream, Charset charset) throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream, charset);
        StringBuilder result = new StringBuilder();
        int ch;
        while(( ch = inputStreamReader.read() ) != -1) {
            result.append((char) ch);
        }
        return result.toString();
    }
}
