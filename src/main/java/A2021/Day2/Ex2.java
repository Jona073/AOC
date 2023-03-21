package A2021.Day2;

import java.io.BufferedReader;
import java.io.FileReader;

public class Ex2 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/java/A2021/Day2/input.txt"))) {
            String line;
            SubmarineV2 s1 = new SubmarineV2();
            while ((line = br.readLine()) != null) {
                s1.move(line.split(" ")[0], Integer.parseInt(line.split(" ")[1]));
            }
            System.out.println(s1.calculCoordonate());
        } catch (Exception e) {
            System.err.println("Erreur " + e);
        }
    }
}
