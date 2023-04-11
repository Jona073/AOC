package A2016.Day3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Triangle {

    private List<Integer> cote = new ArrayList<>();

    public Triangle(int cote1, int cote2, int cote3) {
        cote.add(cote1);
        cote.add(cote2);
        cote.add(cote3);
        Collections.sort(this.cote);
    }

    public Triangle(String texte) {
        String[] lstcote = texte.split("\\s+");
        cote.add(Integer.parseInt(lstcote[1]));
        cote.add(Integer.parseInt(lstcote[2]));
        cote.add(Integer.parseInt(lstcote[3]));
        Collections.sort(this.cote);
    }

    public boolean isPossible() {
        return this.cote.get(2) < this.cote.get(0) + this.cote.get(1);
    }

}
