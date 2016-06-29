package rover;

public enum Direction {
    N, E, S, W;

    public Direction turnLeft(){
        int length = Direction.values().length;
        int indexOfDir = (this.ordinal() + 3) % length;
        return Direction.values()[indexOfDir];
    }

    public Direction turnRight() {
        int length = Direction.values().length;
        int indexOfDir = (this.ordinal() + 1) % length;
        return Direction.values()[indexOfDir];
    }
}
