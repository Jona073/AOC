package A2021.Day2;

public class SubmarineV2 extends Submarine {

    private int aim;

    public SubmarineV2() {
        super();
        this.aim = 0;
    }

    @Override
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
    private void moveAim(int number) {
        this.aim += number;
    }

    @Override
    protected void moveHorizontal(int number) {
        super.moveHorizontal(number);
        this.moveDeep(number * this.aim);
    }

}
