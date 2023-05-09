package A2018.Day3;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Tissu {

    private int id;
    private List<Coordonnee> lstCoordonnes = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void populate(int largeur, int longueur, int espaceHorizontal, int espaceVertical, int id) {
        this.id = id;
        for (int i = 0 ; i < largeur; i++) {
            for (int j = 0; j < longueur; j++) {
                this.lstCoordonnes.add(new Coordonnee(espaceHorizontal+i,espaceVertical+j));
            }
        }
    }

    public List<Coordonnee> getLstCoordonnes() {
        return new ArrayList<>(lstCoordonnes);
    }

    public Tissu(String input) {
        int espaceHorizontal = Integer.parseInt(input.split("@")[1].split(",")[0].trim());
        int espaceVertical = Integer.parseInt(input.split(",")[1].split(":")[0].trim());
        int largeur = Integer.parseInt(input.split(":")[1].split("x")[0].trim());
        int longueur = Integer.parseInt(input.split("x")[1].trim());
        int id = Integer.parseInt(input.split("#")[1].split("@")[0].trim());

        populate(largeur,longueur,espaceHorizontal,espaceVertical,id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tissu)) return false;
        Tissu tissu = (Tissu) o;
        //ID unique donc pas besoin check list
        return id == tissu.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, lstCoordonnes);
    }




}
