package A2018.Day1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Ex2 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/java/A2018/Day1/input.txt"))) {
            String line;
            int tt = 0;
            int i = 0;
            boolean quitter = false;
            List<Integer> lstnb = new ArrayList<>();
            br.mark(5000);
            while (!quitter) {
                while ((line = br.readLine()) != null) {
                    if (line.toCharArray()[0] == '+') {
                        tt += Integer.parseInt(line.substring(1));
                    } else {
                        tt -= Integer.parseInt(line.substring(1));
                    }

                    if (lstnb.contains(tt)) {
                        System.out.println(i);
                        quitter = true;
                        break;
                    }
                    lstnb.add(tt);
                    i++;
                }
                br.reset();
            }
            System.out.println(tt);

        } catch (Exception e) {
            System.err.println("Erreur");
        }

    }
}
