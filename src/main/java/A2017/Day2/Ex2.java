package A2017.Day2;

import java.io.BufferedReader;
import java.io.FileReader;

public class Ex2 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/java/A2017/Day2/input.txt"))) {
            String line;
            int tt = 0;
            int m1;
            int m2;
            boolean test;

            while ((line = br.readLine()) != null) {
                test = true;
                for (String N1:line.split("\t")) {
                    for (String N2:line.split("\t")) {
                        m1 = Integer.parseInt(N1);
                        m2 = Integer.parseInt(N2);
                        if(m1 % m2 == 0 && test && m1!=m2) {
                            tt += m1/m2;
                            test = false;
                        }
                    }
                }
            }
            System.out.println(tt);

        } catch (Exception e) {
            System.err.println("Erreur");
        }
    }
}
