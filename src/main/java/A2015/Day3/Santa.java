package A2015.Day3;

import java.util.ArrayList;
import java.util.List;

public class Santa {
    private Coordonate position;

    private List<Coordonate> visitedHouse;

    public Santa(List<Coordonate> visitedHouse) {
        this.visitedHouse = new ArrayList<>();
        this.visitedHouse.addAll(visitedHouse);
    }

    public Santa() {
        this.position = new Coordonate();
        this.visitedHouse = new ArrayList<>();
    }

    public void move(char direction) {
        switch (direction) {
            case '<':
                position.moveWest();
                break;
            case '>':
                position.moveEast();
                break;
            case '^':
                position.moveNorth();
                break;
            case 'v':
                position.moveSouth();
                break;
            default:
                throw new IllegalArgumentException("Explosion!");
        }
        this.checkVisitedHouse(this.position);
    }

    public void checkVisitedHouse(Coordonate housePosition) {
        if (!visitedHouse.contains(housePosition)) {
            visitedHouse.add(new Coordonate(housePosition.getX(),housePosition.getY()));
        }
    }

    public int numberVisitedHouse() {
        return this.visitedHouse.size();
    }

    public List<Coordonate> getVisitedHouse() {
        List<Coordonate> listCoordonate = new ArrayList<>(this.visitedHouse);
        return listCoordonate;
    }

    public void doRoad(String road) {
        for (char direction : road.toCharArray()) {
            this.move(direction);
        }
    }

    public void addListHouseVisited(List<Coordonate> listHouseVisited) {
        this.visitedHouse.addAll(listHouseVisited);
    }

}
