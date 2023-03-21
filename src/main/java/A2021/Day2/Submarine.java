package A2021.Day2;

public class Submarine {
    private int depth;
    private int horizontalPosition;

    public int getDepth() {
        return depth;
    }

    public int getHorizontalPosition() {
        return horizontalPosition;
    }

    public Submarine() {
        this.depth = 0;
        this.horizontalPosition = 0;
    }

    public Submarine(int depth, int horizontalPosition) {
        this.depth = depth;
        this.horizontalPosition = horizontalPosition;
    }

    public void move(String typeMove, int number) {
        switch (typeMove) {
            case "up":
                this.moveDeep(-number);
                break;
            case "down":
                this.moveDeep(number);
                break;
            case "forward":
                this.moveHorizontal(number);
                break;
            default:
                throw new IllegalArgumentException("PAS normal");
        }
    }

    public void moveDeep(int number) {
        this.depth += number;
    }

    public void moveHorizontal(int number) {
        this.horizontalPosition += number;
    }

    public int calculCoordonate() {
        return this.depth*this.horizontalPosition;
    }

}
