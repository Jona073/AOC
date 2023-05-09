package A2019.Day3;

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

    public void move(Character direction) {
        switch (direction) {
            case 'U':
                this.y += 1;
                break;
            case 'D':
                this.y -= 1;
                break;
            case 'R':
                this.x += 1;
                break;
            case 'L':
                this.x -= 1;
                break;
            default:
                throw new IllegalArgumentException("Pas normal la direction");
        }
    }


    @Override
    public int compareTo(Position p) {
        return this.x + this.y - (p.getX() + p.getY());
    }
}
