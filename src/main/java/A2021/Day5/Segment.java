package A2021.Day5;

import java.util.ArrayList;
import java.util.List;

public class Segment {
    private Point debut;
    private Point fin;

    public Segment(String input) {
        String[] tabPartie = input.split(",| -> ");
        int x1 = Integer.parseInt(tabPartie[0]);
        int y1 = Integer.parseInt(tabPartie[1]);
        int x2 = Integer.parseInt(tabPartie[2]);
        int y2 = Integer.parseInt(tabPartie[3]);
        this.debut = new Point(x1,y1);
        this.fin = new Point(x2,y2);

    }


    // -1 : vertical
    // 1 : horizontal
    // 0 : rien
    public TypeSegment isVerticalOrHorizontalLine() {
        if (this.debut.getX() == this.fin.getX()) {
            return TypeSegment.HORIZONTAL;
        } else if (this.debut.getY() == this.fin.getY()) {
            return TypeSegment.VERTICAL;
        }
        return TypeSegment.DIAGONAL;
    }

    public List<Point> getAllPoints() {
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
        if (this.isVerticalOrHorizontalLine() == TypeSegment.VERTICAL) {

            for (int i = minX; i <= maxX; i++) {
                Point point = new Point(i,this.debut.getY());
                points.add(point);
            }

        } else if (this.isVerticalOrHorizontalLine() == TypeSegment.HORIZONTAL) {

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
