package A2020.Day1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Ex2 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/java/A2020/Day1/input.txt"))) {
            String line;
            int result = 0;
            List<Integer> lstnb = new ArrayList<>();
            while ((line = br.readLine()) != null) {
                lstnb.add(Integer.parseInt(line));
            }

            for (int i = 0; i < lstnb.size()-3; i++) {
                for (int j = i+1; j < lstnb.size()-2; j++) {
                    for (int k = j ; k < lstnb.size()-1; k++) {
                        if (lstnb.get(i) + lstnb.get(j) + lstnb.get(k) == 2020) {
                            result = lstnb.get(i) * lstnb.get(j) * lstnb.get(k);
                            break;
                        }
                    }
                    if (result != 0) {
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
