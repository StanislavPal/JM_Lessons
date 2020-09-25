package Lesson6;

import java.util.Optional;

public class Lesson_6_1_9 {
    public static void main(String[] args) {
        Example<Integer> ex = new Example<>();
        ex.someMethod(Integer.valueOf(1));
    }
}

class Example<X> {
    public void someMethod(Object obj) {
        Optional<X> something = (Optional<X>) obj;
        Optional<X> fff =  Optional.empty();
//        if ( (obj instanceof Optional<X>)) {System.out.println("sldkfj");}
    }
}
