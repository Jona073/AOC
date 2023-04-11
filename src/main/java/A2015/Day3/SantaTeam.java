package A2015.Day3;

import java.util.ArrayList;
import java.util.List;

public class SantaTeam {
    private final List<Santa> team;

    public SantaTeam() {
        this.team = new ArrayList<>();
    }

    public void addSanta(Santa s) {
        this.team.add(s);
    }

    public int numberSanta() {
        return this.team.size();
    }

    public void teamRoad(String road) {
        for (int i = 0; i < road.length(); i++ ) {
            this.team.get(i%this.numberSanta()).move(road.charAt(i));
        }
    }

    public int allVisitedHoused() {
        Santa bigSANTAAAA = new Santa();
        bigSANTAAAA.addListHouseVisited(this.team.get(0).getVisitedHouse());
        for (int i = 1; i < this.numberSanta(); i++) {
            for (Coordonate house : this.team.get(i).getVisitedHouse()) {
                bigSANTAAAA.checkVisitedHouse(house);
            }
        }
        return bigSANTAAAA.numberVisitedHouse();
    }

}
