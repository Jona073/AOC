package A2020.Day1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Ex1 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/java/A2020/Day1/input.txt"))) {
            String line;
            int result = 0;
            List<Integer> lstNb = new ArrayList<>();
            while ((line = br.readLine()) != null) {
                lstNb.add(Integer.parseInt(line));
            }

            for (int i = 0; i < lstNb.size()-2; i++) {
                for (int j = i+1; j < lstNb.size()-1; j++) {
                   if (lstNb.get(i) + lstNb.get(j) == 2020) {
                       result = lstNb.get(i) * lstNb.get(j);
                       break;
                   }
                }
                if (result != 0) {
                    break;
                }
            }
            
            System.out.println(result);
        } catch (Exception e) {
            System.err.println("Erreur " + e);
        }
    }
}
