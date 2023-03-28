package A2015.Day3;

import java.io.BufferedReader;
import java.io.FileReader;

public class Ex1 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/java/A2015/Day3/input.txt"))) {
            String line;
            line = br.readLine();

            Santa santa = new Santa();
            santa.doRoad(line);
            System.out.println(santa.numberVisitedHouse());

        } catch (Exception e) {
            System.err.println("Erreur " + e);
        }
    }
}

