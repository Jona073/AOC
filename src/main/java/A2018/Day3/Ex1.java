package A2018.Day3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Ex1 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/java/A2018/Day3/input.txt"))) {
            String line;
            List<String> inputs = new ArrayList<>();
            while ((line = br.readLine()) != null) {
                inputs.add(line);
            }
            Draps draps = new Draps(inputs);

            System.out.println(" Result : " + draps.nbChevauche());

            System.out.println(" Result 2: " + draps.lElue());
        } catch (Exception e) {
            System.err.println("Erreur " + e);
        }
    }
}
