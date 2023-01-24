package A2018.Day1;

import java.io.BufferedReader;
import java.io.FileReader;

public class Ex1 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/java/A2018/Day1/input.txt"))) {
            String line;
            int tt = 0;

            while ((line = br.readLine()) != null) {
                if (line.toCharArray()[0] == '+')
                {
                    tt += Integer.parseInt(line.substring(1));
                } else {
                    tt -= Integer.parseInt(line.substring(1));
                }
            }
            System.out.println(tt);

        } catch (Exception e) {
            System.err.println("Erreur");
        }

    }
}
