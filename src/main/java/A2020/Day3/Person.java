package A2020.Day3;

public class Person {
    private final Position position;
    private int numberHit;

    public Person() {
        this.numberHit = 0;
        this.position = new Position(0, 0);
    }

    public int getNumberHit() {
        return numberHit;
    }

    public void move(int x, int y, Forest forest) {
        this.position.moveX(forest.getWidth(), x);
        this.position.moveY(y);
        if (forest.getTrees().contains(this.position)) {
            this.numberHit++;
        }
    }

    public void toboggan(int x, int y, Forest forest) {
        for (int i = 0; i < forest.getLength(); i++) {
            this.move(x, y, forest);
        }
    }
}
