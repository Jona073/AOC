package A2018.Day2;

import java.io.BufferedReader;
import java.io.FileReader;

public class Ex1 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/java/A2018/Day2/input.txt"))) {
            String line;
            int total;
            int nbDouble = 0;
            int nbTrois = 0;
            int count;
            boolean appearsTwice;
            boolean appearsThrice;
            while ((line = br.readLine()) != null) {
                appearsTwice = false;
                appearsThrice = false;
                for (char carac : line.toCharArray()) {
                    count = line.length() - line.replaceAll(String.valueOf(carac), "").length();
                    if (count == 2 && !appearsTwice) {
                        nbDouble++;
                        appearsTwice = true;
                    } else if (count == 3 && !appearsThrice) {
                        nbTrois++;
                        appearsThrice = true;
                    }
                }
            }
            total = nbTrois * nbDouble;
            System.out.println(total);
        } catch (Exception e) {
            System.err.println("Erreur " + e);
        }
    }
}
