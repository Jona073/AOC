package A2020.Day3;

import java.util.ArrayList;
import java.util.List;

public class Forest {
    private List<Position> trees = new ArrayList<>();
    private int length;

    private int width;

    public int getLength() {
        return length;
    }

    public List<Position> getTrees() {
        return trees;
    }

    public Forest() {
        length = 0;
    }

    public int getWidth() {
        return width;
    }

    public void addLineTree(String input, int y) {
        this.width = input.length();
        for (int x = 0; x < input.length(); x++) {
            if (input.charAt(x) == '#') {
                trees.add(new Position(x, y));
            }
        }
        this.length++;
    }

}
