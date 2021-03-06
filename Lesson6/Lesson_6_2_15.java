package Lesson6;

import java.io.Reader;
import java.io.StringReader;
import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Lesson_6_2_15 {
    public static void main(String[] args) {
        String str = "Алексей 3000\n" +
                "Дмитрий 9000\n" +
                "Антон 3000\n" +
                "Алексей 7000\n" +
                "Антон 8000";
        StringReader stringReader = new StringReader(str);
        System.out.println( getSalesMap(stringReader) );
    }

    public static Map<String, Long> getSalesMap(Reader reader) {
        Scanner scanner = new Scanner(reader);
        Map<String, Long> map = new HashMap<>();

        map.put(null, 10l);
        map.put(null, 20l);

        while(scanner.hasNext()) {
            String key = scanner.next();

            Long value = 0l;
            if(scanner.hasNextLong() ) {
                value = scanner.nextLong();
            }

            if (map.containsKey(key)) {
                value += map.get(key);
            }
            map.put(key, value);
        }
        scanner.close();
        return map;
    }

}
