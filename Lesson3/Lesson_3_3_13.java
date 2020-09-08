package Lesson3;

public class Lesson_3_3_13 {
    public static void main(String[] args) {

        Robot robot = new Robot(15, 3, Direction.RIGHT);
        moveRobot3(robot, 15, -3);

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
        }
    }

    public static void moveRobot3(Robot robot, int toX, int toY) {
        Direction toDirectionY = Direction.DOWN;
        Direction toDirectionX = Direction.RIGHT;

        int rX = robot.getX();
        int rY = robot.getY();

        while ((rX != toX) || (rY != toY)) {
            if (toY > rY) {
                toDirectionY = Direction.UP;
            } else if (toY < rY) {
                toDirectionY = Direction.DOWN;
            }
            if (toX > rX) {
                toDirectionX = Direction.RIGHT;
            } else if (toX < rX) {
                toDirectionX = Direction.LEFT;
            }

            if (rX == toX) {
                if (robot.getDirection() != toDirectionY) {
                    rotateRobot(robot, toDirectionY);
                }
            } else if (rY == toY) {
                if (robot.getDirection() != toDirectionX) {
                    rotateRobot(robot, toDirectionX);
                }
            } else {
                if ((robot.getDirection() != toDirectionY)
                        && (robot.getDirection() != toDirectionX)) {
                    if ((robot.getDirection() == Direction.DOWN) || (robot.getDirection() == Direction.UP)) {
                        rotateRobot(robot, toDirectionX);
                    } else {
                        rotateRobot(robot, toDirectionY);
                    }
                }
            }


            robot.stepForward();
            rX = robot.getX();
            rY = robot.getY();
        }
    }





    private static void rotateRobot(Robot robot, Direction toDir) {
        Direction rDir = robot.getDirection();
        if (rDir == toDir) {
            return;
        } else if ((((rDir == Direction.UP) || (rDir == Direction.DOWN)) && ((toDir == Direction.UP) || (toDir == Direction.DOWN)))
                || (((rDir == Direction.RIGHT) || (rDir == Direction.LEFT)) && ((toDir == Direction.RIGHT) || (toDir == Direction.LEFT)))) {
            robot.turnRight();
            robot.turnRight();
        } else if (((rDir == Direction.UP) && (toDir == Direction.RIGHT))
                || ((rDir == Direction.RIGHT) && (toDir == Direction.DOWN))
                || ((rDir == Direction.DOWN) && (toDir == Direction.LEFT))
                || ((rDir == Direction.LEFT) && (toDir == Direction.UP))) {
            robot.turnRight();
        } else {
            robot.turnLeft();
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
        System.out.println("turn left");
        switch (direction) {
            case UP:
                direction = Direction.LEFT;
                break;
            case RIGHT:
                direction = Direction.UP;
                break;
            case DOWN:
                direction = Direction.RIGHT;
                break;
            case LEFT:
                direction = Direction.DOWN;
                break;
        }
    }

    public void turnRight() {
        // повернуться на 90 градусов по часовой стрелке
        System.out.println("turn right");
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
        System.out.printf("step: x = %d, y = %d, dir = %s\n", x, y, direction);

    }
}

enum Direction {
    UP,
    DOWN,
    LEFT,
    RIGHT
}