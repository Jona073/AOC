package A2015.Day1;

import java.io.BufferedReader;
import java.io.FileReader;

public class Ex1 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/java/A2015/Day1/input.txt"))) {
            char[] line = br.readLine().toCharArray();
            int total = 0;
            for (char car: line) {
                if (car == '(') {
                    total ++;
                } else {
                    total --;
                }
            }

            System.out.println("Etage : " + total);
        } catch (Exception e) {
            System.err.println("Erreur");
        }
    }
}
