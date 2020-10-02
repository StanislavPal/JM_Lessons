package Lesson4;

public class Lesson_4_1_8 {
    public static void main(String[] args) {
        System.out.println( getCallerClassAndMethodName() );
        anotherMethod();
    }

    private static void anotherMethod() {
        System.out.println( getCallerClassAndMethodName() );
    }

    public static String getCallerClassAndMethodName() {
            StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
            int i;
            for(i = 0; i < stackTraceElements.length; i++) {
                System.out.println(stackTraceElements[i] + " " + i);
                if ( stackTraceElements[i].getMethodName() == "getCallerClassAndMethodName") {
//                    break;
                }
            }
            return "aaa";
//            if ( stackTraceElements[i+1].getMethodName() == "main") {
//                return null;
//            }
//            return  stackTraceElements[i+1].getClassName()
//                    + "#"
//                    + stackTraceElements[i+1].getMethodName();
    }
}