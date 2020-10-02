package Lesson5.Help;

import java.io.*;
import java.util.Arrays;

public class L_5_2_8 {
    public static void main(String[] args) throws IOException {
        print(System.in, System.out);
    }

    public static void print(InputStream inputStream, OutputStream outputStream) throws IOException {
        int b;
        while ((b = (byte) inputStream.read()) != -1) {
            if (b % 2 == 0) {
                outputStream.write(b);
            }
        }
    }
}