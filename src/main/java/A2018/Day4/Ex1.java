package A2018.Day4;

import java.io.BufferedReader;
import java.io.FileReader;

public class Ex1 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/java/A2018/Day4/input.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {

            }
        } catch (Exception e) {
            System.err.println("Erreur " + e);
        }
    }
}
