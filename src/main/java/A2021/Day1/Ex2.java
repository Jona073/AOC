package A2021.Day1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Ex2 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/java/A2021/Day1/input.txt"))) {
            String line;
            int nbIncr = 0;
            int nb;
            List<Integer> lstnb = new ArrayList<>();
            while ((line = br.readLine()) != null) {
                lstnb.add(Integer.parseInt(line));
            }

            nb = lstnb.get(0) + lstnb.get(1) + lstnb.get(2);
            for (int i = 1; i < lstnb.size()-2; i++) {
                if(nb < (lstnb.get(i) + lstnb.get(i+1) + lstnb.get(i+2))) {
                    nbIncr ++;
                }

                nb = lstnb.get(i) + lstnb.get(i+1) + lstnb.get(i+2)  ;
            }
            
            System.out.println(nbIncr);
        } catch (Exception e) {
            System.err.println("Erreur " + e);
        }
    }
}
