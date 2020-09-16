package Lesson4.Lesson_4_2_8;

public class Main {
    public static void main(String[] args) {

    }

    public static void moveRobot(RobotConnectionManager robotConnectionManager, int toX, int toY) {
        RobotConnection robotConnection = null;
        int counter = 0;
        while (counter < 3) {
            try {
                robotConnection = robotConnectionManager.getConnection();
                robotConnection.moveRobotTo(toX, toY);
                break;
            } catch (RobotConnectionException e) {
                counter++;
            } catch (Throwable throwable) {
                throw throwable;
            }
            finally {
                try {
                    if (robotConnection != null) {
                        robotConnection.close();
                    }
                } catch (Exception exception) {

                }
            }
        }
        if (counter == 3) {
            throw new RobotConnectionException("Сделано 3 неудачных попытки соединения!");
        }
    }
}
