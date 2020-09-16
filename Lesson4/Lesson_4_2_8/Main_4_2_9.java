package Lesson4.Lesson_4_2_8;

public class Main_4_2_9 {
    public static void main(String[] args) {

    }

    public static void moveRobot(RobotConnectionManager robotConnectionManager, int toX, int toY) {
        int i;
        for (i = 0; i < 3; i++) {
            try (RobotConnection robotConnection = robotConnectionManager.getConnection()) {
                robotConnection.moveRobotTo(toX, toY);
                break;
            } catch (RobotConnectionException e) {
            } catch (Throwable throwable) {
                throw throwable;
            }
        }
        if (i == 3) {
            throw new RobotConnectionException("Сделано 3 неудачных попытки соединения!");
        }
    }
}
