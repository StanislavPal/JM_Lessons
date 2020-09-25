package Lesson4.Lesson_4_2_8;

public class Main_4_2_9 {
    public static void main(String[] args) {

    }

    public static void moveRobot(RobotConnectionManager robotConnectionManager, int toX, int toY) throws Exception {
        int countOfFalseTry = 3;
        int i;
        for (i = 0; i < countOfFalseTry; i++) {
            try (RobotConnection robotConnection = robotConnectionManager.getConnection()) {
                robotConnection.moveRobotTo(toX, toY);
                // переполняем счетчик для выхода из цикла. т.к. break и return нельзя испльзовать
                // из-за возможного исключения при закрытии ресурса
                i = countOfFalseTry + 1;
            } catch (RobotConnectionException e) {
            } catch (Exception e) {
                throw e;
            }
        }
        if (i == countOfFalseTry) {
            throw new RobotConnectionException("3 unsuccessful connection attempts!");
        }
    }
}
