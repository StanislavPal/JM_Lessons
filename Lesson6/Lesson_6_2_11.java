package Lesson6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class Lesson_6_2_11 {
    public static void main(String[] args) {
        Collection<?> collection = new ArrayList<>();
        Object object = Integer.valueOf(1);

//        collection.add(object);
        collection.contains(object);
//        collection.addAll(Arrays.asList(new Object[]{object}));
        collection.clear();
        collection.remove(object);
        collection.toArray();
        collection.iterator();
        collection.size();

    }
}
