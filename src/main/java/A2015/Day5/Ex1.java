package A2015.Day5;

import java.io.BufferedReader;
import java.io.FileReader;

public class Ex1 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/java/A2015/Day2/input.txt"))) {
            String line;
            int count = 0;

            while ((line = br.readLine()) != null) {

            }
            System.out.println(count);

        } catch (Exception e) {
            System.err.println("Erreur");
        }
    }

    public boolean isNice() {


        return true;
    }
}
