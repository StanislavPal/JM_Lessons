package Lesson6.review;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class HashMapTest {
    public static void main(String[] args) {
        Map<Integer, String> map = new LinkedHashMap<>(5, 1, true);
        map.put(5, "a");
        map.put(4, "b");
        map.put(3, "c");
        map.put(2, "d");
        map.put(1, "e");
        map.get(3);
        map.get(5);
        map.get(1);
        System.out.println(map);
    }
}
