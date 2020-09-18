package Lesson4.Lesson_4_2_8_Test;

public class RobotException extends RuntimeException {
    public RobotException(String message) { System.out.println("=== Бросаем ексепшн! === : " + message); }

}
