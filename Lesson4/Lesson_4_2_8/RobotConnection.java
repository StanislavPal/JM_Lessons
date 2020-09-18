package Lesson4.Lesson_4_2_8;

public interface RobotConnection extends AutoCloseable {
    void moveRobotTo(int x, int y);
}
