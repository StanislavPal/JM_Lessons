package Lesson4.Lesson_4_2_8;

public class Robot implements RobotConnection, RobotConnectionManager{
    @Override
    public void moveRobotTo(int x, int y) {
        System.out.printf("Робот переместился в точку (%d, %d)", x, y);
    }


    @Override
    public RobotConnection getConnection() {
        System.out.println("Соединение с роботом открыто!");
        return new Robot();
    }

    @Override
    public void close() throws Exception {
        System.out.println("Соединение с роботом закрыто!");
    }
}
