package Lesson5;

import java.io.IOException;
import java.io.InputStreamReader;

public class Lesson_5_3_12 {
    public static void main(String[] args) {
        Double sum = 0.0;
        try(InputStreamReader isr = new InputStreamReader(System.in, "UTF-8")) {
            StringBuilder buffer = new StringBuilder();
            int i;
            char ch;
            while ((i = isr.read()) != -1) {
                ch = (char) i;
                if((ch != ' ') && (ch != '\n')) {
                    buffer.append(ch);
                } else {
                    try {
                        sum += Double.parseDouble(buffer.toString());
                    } catch (NumberFormatException e) {
                    }
                    buffer.setLength(0);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.printf("%.6f", sum);
    }
}
