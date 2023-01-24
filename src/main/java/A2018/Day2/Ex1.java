package A2018.Day2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class Ex1 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/java/A2018/Day1/input.txt"))) {
            String line;
            int total;
            int nbDouble = 0;
            int nbTrois = 0;

            while ((line = br.readLine()) != null) {

            }
            total = nbTrois * nbDouble;
            System.out.println(total);
        } catch (Exception e) {
            System.err.println("Erreur " + e);
        }
    }
}
