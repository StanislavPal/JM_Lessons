package Lesson4.Lesson_4_2_8;

public class Main_4_2_9_notPassTest {
    public static void main(String[] args) {

    }

    public static void moveRobot(RobotConnectionManager robotConnectionManager, int toX, int toY) throws Exception {
        int counter = 0;
        boolean bConnect = false;
        while ((counter < 3) & !bConnect) {
            try ( RobotConnection robotConnection = robotConnectionManager.getConnection() ){
                robotConnection.moveRobotTo(toX, toY);
                bConnect = true;
            } catch (RobotConnectionException e) {
                counter++;
            } catch (Throwable throwable) {
                throw throwable;
            }
        }
        if (counter == 3) {
            throw new RobotConnectionException("Сделано 3 неудачных попытки соединения!");
        }
    }
}
