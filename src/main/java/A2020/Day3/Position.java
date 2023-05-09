package A2020.Day3;

import java.util.Objects;

public class Position implements Comparable<Position> {
    private int x;
    private int y;


    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void moveX(int width, int step) {
        this.x = (this.x + step) % width;
    }

    public void moveY(int y) {
        this.y += y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Position)) return false;
        Position position = (Position) o;
        return x == position.x && y == position.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public int compareTo(Position p) {
        return this.x + this.y - (p.getX() + p.getY());
    }
}
