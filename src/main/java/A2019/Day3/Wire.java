package A2019.Day3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Wire {

    private List<Position> path;

    public Wire() {
        this.path = new ArrayList<>();
        this.path.add(new Position(0,0));
    }

    public List<Position> getPath() {
        return new ArrayList<>(path);
    }

    public void move(char direction, int num) {
        for (int i = 0; i < num; i++) {
            //Recup dernier endroit et le bouge
            Position lastPos = this.path.get(this.path.size()-1);

            Position newPosition = new Position(lastPos.getX(), lastPos.getY());

            newPosition.move(direction);
            this.path.add(newPosition);
        }
    }

    public void addPath(String Allpath) {
        List<String> paths = Arrays.asList(Allpath.split(","));

        for (String move:paths) {
            this.move(move.charAt(0),Integer.parseInt(move.substring(1)));
        }
    }

    public Set<Position> getListNoeudWithOther(Wire wire2) {
        List<Position> allPosition = new ArrayList<>();
        //Ne pas compter les noeuds dans le même fil
        Set<Position> poss1 = new HashSet<>(this.getPath());
        Set<Position> poss2 = new HashSet<>(wire2.getPath());

        allPosition.addAll(poss1);
        allPosition.addAll(poss2);
        Position depart = new Position(0,0);
        allPosition.remove(depart);

        Set<Position> lstUnique = new HashSet<>();
        return allPosition.stream()
                .filter(Predicate.not(lstUnique::add))
                .collect(Collectors.toSet());
    }

    public Position getClosestNoeud(Wire wire2) {
        Set<Position> noeuds = new HashSet<>();
        noeuds.addAll(this.getListNoeudWithOther(wire2));

        Position positionClose = new Position(Integer.MAX_VALUE,Integer.MAX_VALUE);
        int countPosClose;
        int countPosActual;
        for (Position noeud:noeuds) {

            // Distance = X + Y
            countPosClose = Math.abs(positionClose.getX()) + Math.abs(positionClose.getY());
            countPosActual = Math.abs(noeud.getX()) + Math.abs(noeud.getY());
            if (countPosActual < countPosClose) {
                positionClose = noeud;
            }
        }
        return positionClose;
    }

    public int topFastNoeud(Wire wire2) {
        int minStep = 999999999;
        Set<Position> noeuds = new HashSet<>();
        noeuds.addAll(this.getListNoeudWithOther(wire2));

        int stepWire1;
        int stepWire2;
        int stepNoeud;
        for (Position noeud:noeuds) {
            stepWire1 = this.path.indexOf(noeud) ;
            stepWire2 = wire2.getPath().indexOf(noeud) ;
            stepNoeud = stepWire1 + stepWire2;
            if (stepNoeud < minStep) {
                minStep = stepNoeud;
            }
        }


        return minStep;
    }


}
