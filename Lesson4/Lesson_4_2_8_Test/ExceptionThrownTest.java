package Lesson4.Lesson_4_2_8_Test;

import java.io.FileNotFoundException;

public class ExceptionThrownTest {

//    @Test
//    public void testingExceptions() {
//
//        try {
//            ExceptionThrownTest.main(new String[] {});
//        } catch (Throwable e) {
//            System.out.println("Проверка исключения: " + (e instanceof RuntimeException));
//        }
//
//    }

    public static void main(String[] args) throws FileNotFoundException {

        dangerousMethod();

        // Won't be executed because RuntimeException thrown
        unreachableMethod();

    }

    private static void dangerousMethod() {
        throw new RuntimeException();
    }

    private static void unreachableMethod() {
        System.out.println("Won't execute");
    }
}