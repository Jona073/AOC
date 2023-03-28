package A2015.Day3;

import java.util.Objects;

public class Coordonate {
    private int x;
    private int y;

    public Coordonate() {
        this.x = 0;
        this.y = 0;
    }

    public Coordonate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void moveEast() {
        this.x -=1;
    }
    public void moveWest() {
        this.x +=1;
    }
    public void moveNorth() {
        this.y +=1;
    }
    public void moveSouth() {
        this.y -=1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Coordonate)) return false;
        Coordonate that = (Coordonate) o;
        return x == that.x && y == that.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
