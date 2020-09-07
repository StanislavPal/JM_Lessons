package Lesson3;

public class Lesson_3_3_13 {
    public static void main(String[] args) {

        Robot robot = new Robot(15, 300, Direction.UP);
        moveRobot2(robot, 15, -1000);

    }

    public static void moveRobot(Robot robot, int toX, int toY) {
        Direction toDirection;

        if (robot.getX() != toX) {

            if ( toX > robot.getX() ) {
                toDirection = Direction.RIGHT;
            } else {
                toDirection = Direction.LEFT;
            }

        } else if  (robot.getY() != toY) {

            if ( toY > robot.getY() ) {
                toDirection = Direction.UP;
            } else {
                toDirection = Direction.DOWN;
            }

        } else {
            return;
        }

        while (robot.getDirection() != toDirection) {
            robot.turnRight();
        }

        robot.stepForward();
        moveRobot(robot, toX, toY);
    }

    public static void moveRobot2(Robot robot, int toX, int toY) {
        Direction toDirection = Direction.DOWN;
        int rX = robot.getX();
        int rY = robot.getY();
        while ( (rX != toX) || (rY != toY) ) {
            if (rX != toX) {
                if (toX > rX) {
                    toDirection = Direction.RIGHT;
                } else {
                    toDirection = Direction.LEFT;
                }
            } else if (rY != toY) {
                if (toY > rY) {
                    toDirection = Direction.UP;
                } else {
                    toDirection = Direction.DOWN;
                }
            }
            while (robot.getDirection() != toDirection) {
                robot.turnRight();
            }
            robot.stepForward();
            rX = robot.getX();
            rY = robot.getY();
            System.out.printf("x = %d, y = %d, dir = %s\n ", rX, rY, robot.getDirection());
        }
    }
}

class Robot {
    private int x;
    private int y;
    private Direction direction;

    public Robot(int x, int y, Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public Direction getDirection() {
        return direction;
    }

    public int getX() {
        return x; // текущая координата X
    }

    public int getY() {
        return y; // текущая координата Y
    }

    public void turnLeft() {
        // повернуться на 90 градусов против часовой стрелки
    }

    public void turnRight() {
        // повернуться на 90 градусов по часовой стрелке
        switch (direction) {
            case UP:
                direction = Direction.RIGHT;
                break;
            case RIGHT:
                direction = Direction.DOWN;
                break;
            case DOWN:
                direction = Direction.LEFT;
                break;
            case LEFT:
                direction = Direction.UP;
                break;
        }
    }

    public void stepForward() {
        // шаг в направлении взгляда
        // за один шаг робот изменяет одну свою координату на единицу
        int dx;
        int dy;

        switch (direction) {
            case UP:
                dy = 1;
                dx = 0;
                break;
            case RIGHT:
                dy = 0;
                dx = 1;
                break;
            case DOWN:
                dy = -1;
                dx = 0;
                break;
            case LEFT:
                dy = 0;
                dx = -1;
                break;
            default:
                dx = 0;
                dy = 0;
        }

        x += dx;
        y += dy;

    }
}

enum Direction {
    UP,
    DOWN,
    LEFT,
    RIGHT
}