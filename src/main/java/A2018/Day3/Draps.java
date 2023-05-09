package A2018.Day3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Draps {
    List<Tissu> tissues = new ArrayList<>();

    public Draps(List<String> inputs) {
        //faire convertion en lst
        for (String line : inputs) {
            this.tissues.add(new Tissu(line));
        }
    }


    public Set<Coordonnee> coordonneeChevauche() {
        List<Coordonnee> coordonnees = new ArrayList<>();
        for (Tissu tissue : this.tissues) {
            coordonnees.addAll(tissue.getLstCoordonnes());
        }

        Set<Coordonnee> lstUnique = new HashSet<>();
        return coordonnees.stream().filter(Predicate.not(lstUnique::add)).collect(Collectors.toSet());

    }

    public int nbChevauche() {
        return this.coordonneeChevauche().size();
    }

    public int lElue() {
        //Liste des coordonnées en double donc juste a voir un tissue qui ne les utilise pas
        Set<Coordonnee> coordonnees = new HashSet<>(this.coordonneeChevauche());

        for (Tissu tissu : this.tissues) {
            if (tissu.getLstCoordonnes().stream().noneMatch(coordonnees::contains)) {
                return tissu.getId();
            }
        }

        return 0;
    }

}
