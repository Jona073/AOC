package A2019.Day1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Ex1 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/java/A2019/Day1/input.txt"))) {
            String line;
            int total = 0;
            double nb;
            while ((line = br.readLine()) != null) {
                nb = Math.floor(Integer.parseInt(line) / 3) - 2;
                while (nb>0) {
                    total += nb;
                    nb = Math.floor(nb / 3) - 2;
                }
            }
            System.out.println(total);
        } catch (Exception e) {
            System.err.println("Erreur " + e);
        }
    }
}
