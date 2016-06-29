package rover;

import java.util.Arrays;
import java.util.List;

public class MarsRover {
//    private static final List<String> VALID_COMMANDS = Arrays.asList("L", "R", "M");
//    private static final List<String> DIRECTIONS = Arrays.asList("N", "E", "S", "W");

    private static final int Y = 1;
    private static final int X = 0;

    private Direction directionCurrent;
//    private Direction direction;
//    private int[] position;
    private Position position;

    public MarsRover(int startingX, int startingY, String directionCurrent) {
//        this.position = new int[]{startingX, startingY};
        this.position = new Position (startingX, startingY);
        this.directionCurrent = Direction.valueOf(directionCurrent);
    }

    public String run(String input) {
        String[] commands = convertInputIntoCommands(input);

        for (String command : commands) {
            if (command.equals("M")) {
                move();
            } else if (command.equals("R")) {
                turnRight();
            } else if (command.equals("L")) {
                turnLeft();
            }
        }

        return asString();
    }

    private void move() {
        if (directionCurrent.name().equals("N")) {
            position.plusY(1);
        } else if (directionCurrent.name().equals("S")) {
            position. plusY(-1);
        } else if (directionCurrent.name().equals("E")) {
            position.plusX(1);
        } else if (directionCurrent.name().equals("W")) {
            position.plusX(-1);
        }
    }

    private String asString() {
        return position.getX() + " " + position.getY() + " " + directionCurrent;
    }

    private void turnLeft() {
        directionCurrent = directionCurrent.turnLeft();
    }

    private void turnRight() {
        directionCurrent = directionCurrent.turnRight();
    }

    private static String[] convertInputIntoCommands(String input) {
        String[] commandArray = input.split("(?!^)");

        validateCommands(input, commandArray);

        return commandArray;
    }

    private static void validateCommands(String input, String[] commandArray) {
        for (String command : commandArray) {
            if (Command.valueOf(command)) {
                throw new IllegalArgumentException("Invalid command sequence: " + input);
            }
        }
    }


}
