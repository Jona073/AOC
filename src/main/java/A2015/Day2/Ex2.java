package A2015.Day2;

import java.io.BufferedReader;
import java.io.FileReader;

public class Ex2 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/java/A2015/Day2/input.txt"))) {
            String line;
            int tt = 0;

            int l;
            int w;
            int h;

            while ((line = br.readLine()) != null) {
                l = Integer.parseInt(line.split("x")[0]);
                w = Integer.parseInt(line.split("x")[1]);
                h = Integer.parseInt(line.split("x")[2]);

                if ((l+w)*2 <= (w+h)*2 && (l+w)*2 <= (l+h)*2) {
                    tt+= (l+w)*2;
                } else if ((w+h)*2 <= (l+w)*2 && (w+h)*2 <= (l+h)*2) {
                    tt+= (w+h)*2;
                } else {
                    tt+= (l+h)*2;
                }

                tt += l*w*h;
            }
            System.out.println(tt);

        } catch (Exception e) {
            System.err.println("Erreur");
        }
    }
}
