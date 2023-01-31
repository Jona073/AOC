package A2021.Day1;

import java.io.BufferedReader;
import java.io.FileReader;

public class Ex1 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/java/A2021/Day1/input.txt"))) {
            String line;
            int totalIncr = 0;
            int nb = Integer.parseInt(br.readLine());
            while ((line = br.readLine()) != null) {
                if (Integer.parseInt(line) > nb) {
                    totalIncr ++;
                }
                nb = Integer.parseInt(line);
            }
            System.out.println(totalIncr);
        } catch (Exception e) {
            System.err.println("Erreur " + e);
        }
    }
}
