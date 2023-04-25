package A2018.Day3;

import java.util.Objects;

public class Coordonnee {
    private int x;
    private int y;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Coordonnee)) return false;
        Coordonnee that = (Coordonnee) o;
        return x == that.x && y == that.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Coordonnee(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
