package A2015.Day3;

import java.io.BufferedReader;
import java.io.FileReader;

public class Ex2 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/java/A2015/Day3/input.txt"))) {
            String line;
            line = br.readLine();

            Santa santa = new Santa();
            Santa roboSanta = new Santa();
            SantaTeam team = new SantaTeam();
            team.addSanta(santa);
            team.addSanta(roboSanta);

            team.teamRoad(line);

            System.out.println(team.allVisitedHoused());

        } catch (Exception e) {
            System.err.println("Erreur " + e);
        }
    }
}

