package A2021.Day5;

import java.util.ArrayList;
import java.util.List;

public class Segment {
    private Point debut;
    private Point fin;

    public Segment(String input) {
        int x1 = Integer.parseInt(input.split(",")[0]);
        int y1 = Integer.parseInt(input.split(",")[1].split(" ")[0]);
        int x2 = Integer.parseInt(input.split("-> ")[1].split(",")[0]);
        int y2 = Integer.parseInt(input.split(",")[2]);
        this.debut = new Point(x1,y1);
        this.fin = new Point(x2,y2);

    }


    // -1 : vertical
    // 1 : horizontal
    // 0 : rien
    public int isVerticalOrHorizontalLine() {
        if (this.debut.getX() == this.fin.getX()) {
            return 1;
        } else if (this.debut.getY() == this.fin.getY()) {
            return -1;
        }
        return 0;
    }

    public List<Point> getAllPoint() {
        List<Point> points = new ArrayList<>();
        if (this.isVerticalOrHorizontalLine() == -1) {
            int max = this.fin.getX();
            int min = this.debut.getX();
            if (this.debut.getX() > this.fin.getX()) {
                max = this.debut.getX();
                min = this.fin.getX();
            }
            for (int i = min; i <= max; i++) {
                Point point = new Point(i,this.debut.getY());
                points.add(point);
            }

        } else if (this.isVerticalOrHorizontalLine() == 1) {
            int max = this.fin.getY();
            int min = this.debut.getY();
            if (this.debut.getY() > this.fin.getY()) {
                max = this.debut.getY();
                min = this.fin.getY();
            }
            for (int i = min; i <= max; i++) {
                Point point = new Point(this.debut.getX(),i);
                points.add(point);
            }
        }
        return points;
    }
}
