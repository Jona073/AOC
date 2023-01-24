package A2017.Day2;

import java.io.BufferedReader;
import java.io.FileReader;

public class Ex1 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/java/A2017/Day2/input.txt"))) {
            String line;
            int tt = 0;
            int min;
            int max;

            while ((line = br.readLine()) != null) {
                min = 0;
                max = 0;
                for (String Nombre:line.split("\t")) {
                    if (Integer.parseInt(Nombre) < min || min ==0) {
                        min = Integer.parseInt(Nombre);
                    }
                    if (Integer.parseInt(Nombre) > max || max ==0) {
                        max = Integer.parseInt(Nombre);
                    }
                }


                tt += max -min;
            }
            System.out.println(tt);

        } catch (Exception e) {
            System.err.println("Erreur");
        }
    }
}
