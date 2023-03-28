package A2015.Day3;

import java.util.ArrayList;
import java.util.List;

public class SantaTeam {
    private List<Santa> santaTeam;

    public SantaTeam(List<Santa> santaTeam) {
        this.santaTeam = santaTeam;
    }

    public SantaTeam() {
        this.santaTeam = new ArrayList<>();
    }

    public void addSanta(Santa s) {
        this.santaTeam.add(s);
    }

    public int numberSanta() {
        return this.santaTeam.size();
    }

    public void teamRoad(String road) {
        for (int i = 0; i < road.length(); i++ ) {
            this.santaTeam.get(i%this.numberSanta()).move(road.charAt(i));
        }
    }

    public int allVisitedHoused() {
        Santa bigSANTAAAA = new Santa();
        bigSANTAAAA.addListHouseVisited(this.santaTeam.get(0).getVisitedHouse());
        for (int i = 1; i < this.numberSanta(); i++) {
            for (Coordonate house : this.santaTeam.get(i).getVisitedHouse()) {
                bigSANTAAAA.checkVisitedHouse(house);
            }
        }
        return bigSANTAAAA.numberVisitedHouse();
    }

}
