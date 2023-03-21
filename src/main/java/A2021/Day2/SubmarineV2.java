package A2021.Day2;

public class SubmarineV2 {
    private int depth;
    private int horizontalPosition;

    private int aim;

    public int getDepth() {
        return depth;
    }

    public int getHorizontalPosition() {
        return horizontalPosition;
    }

    public int getAim() {
        return aim;
    }

    public SubmarineV2() {
        this.depth = 0;
        this.horizontalPosition = 0;
        this.aim = 0;

    }

    public SubmarineV2(int depth, int horizontalPosition) {
        this.depth = depth;
        this.horizontalPosition = horizontalPosition;
        this.horizontalPosition = 0;
    }

    public void move(String typeMove, int number) {
        switch (typeMove) {
            case "up":
                this.moveAim(-number);
                break;
            case "down":
                this.moveAim(number);
                break;
            case "forward":
                this.moveHorizontal(number);
                break;
            default:
                throw new IllegalArgumentException("PAS normal");
        }
    }
    public void moveAim(int number) {
        this.aim += number;
    }
    public void moveDeep(int number) {
        this.depth += number;
    }
    public void moveHorizontal(int number) {
        this.horizontalPosition += number;
        this.moveDeep(number * this.aim);
    }

    public int calculCoordonate() {
        return this.depth*this.horizontalPosition;
    }

}
