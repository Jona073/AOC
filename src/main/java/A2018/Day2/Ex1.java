package A2018.Day2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Ex1 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/java/A2018/Day2/input.txt"))) {
            String line;
            int total;
            int nbDouble = 0;
            int nbTrois = 0;
            int count;
            boolean tstDouble;
            boolean tstTrois ;
            while ((line = br.readLine()) != null) {
                tstDouble = true;
                tstTrois = true;
                for (char carac :line.toCharArray()) {
                    count = line.length() - line.replaceAll(String.valueOf(carac),"").length();
                    if(count == 2 && tstDouble) {
                        nbDouble ++;
                        tstDouble = false;
                    }
                    if(count == 3 && tstTrois) {
                        nbTrois ++;
                        tstTrois = false;
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
