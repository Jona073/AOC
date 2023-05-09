package A2019.Day3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Ex1 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/java/A2019/Day3/input.txt"))) {
            String line;
            List<Wire> wires = new ArrayList<>();
            while ((line = br.readLine()) != null) {
                Wire wire = new Wire();
                wire.addPath(line);
                wires.add(wire);
            }

            Wire w1 = wires.get(0);
            Wire w2 = wires.get(1);
            Position posClose = w1.getClosestNoeud(w2);
            int distance = Math.abs(posClose.getX()) + Math.abs(posClose.getY());
            System.out.println(distance);

            distance = w1.topFastNoeud(w2);
            System.out.println(distance);

        } catch (Exception e) {
            System.err.println("Erreur " + e);
        }
    }
}
