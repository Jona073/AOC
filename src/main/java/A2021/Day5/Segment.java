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
        int maxX = this.fin.getX();
        int minX = this.debut.getX();
        if (this.debut.getX() > this.fin.getX()) {
            maxX = this.debut.getX();
            minX = this.fin.getX();
        }
        int maxY = this.fin.getY();
        int minY = this.debut.getY();
        if (this.debut.getY() > this.fin.getY()) {
            maxY = this.debut.getY();
            minY = this.fin.getY();
        }
        if (this.isVerticalOrHorizontalLine() == -1) {

            for (int i = minX; i <= maxX; i++) {
                Point point = new Point(i,this.debut.getY());
                points.add(point);
            }

        } else if (this.isVerticalOrHorizontalLine() == 1) {

            for (int i = minY; i <= maxY; i++) {
                Point point = new Point(this.debut.getX(),i);
                points.add(point);
            }
        } else {
            int difX = maxX - minX;
            int difY = maxY - minY;
            if(difX == difY) {
                for (int i = 0; i <= difX; i++) {
                    int xPas = i;
                    if (minX != this.debut.getX()) {
                        xPas = -i;
                    }
                    int yPas = i;
                    if (minY != this.debut.getY()) {
                        yPas = -i;
                    }
                    Point point = new Point(this.debut.getX()+xPas,this.debut.getY()+yPas);
                    points.add(point);
                }
            }
        }
        return points;
    }
}
