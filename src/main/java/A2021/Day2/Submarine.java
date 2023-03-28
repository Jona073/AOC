package A2021.Day2;

public class Submarine {
    protected int depth;
    protected int horizontalPosition;

    public Submarine() {
        this.depth = 0;
        this.horizontalPosition = 0;
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

    protected void moveDeep(int number) {
        this.depth += number;
    }

    protected void moveHorizontal(int number) {
        this.horizontalPosition += number;
    }

    public int calculCoordonate() {
        return this.depth*this.horizontalPosition;
    }

}
