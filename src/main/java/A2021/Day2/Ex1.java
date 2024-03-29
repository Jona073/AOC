package A2021.Day2;

import java.io.BufferedReader;
import java.io.FileReader;

public class Ex1 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/java/A2021/Day2/input.txt"))) {
            String line;
            Submarine s1 = new Submarine();
            while ((line = br.readLine()) != null) {
                String[] informations = line.split(" ");
                // [typemove X]
                s1.move(informations[0], Integer.parseInt(informations[1]));
            }
            System.out.println(s1.calculCoordonate());
        } catch (Exception e) {
            System.err.println("Erreur " + e);
        }
    }
}
