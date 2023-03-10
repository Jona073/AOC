package A2019.Day1;
import java.io.BufferedReader;
import java.io.FileReader;

public class Ex1 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/java/A2019/Day1/input.txt"))) {
            String line;
            int total = 0;
            while ((line = br.readLine()) != null) {
                total += Integer.parseInt(line) / 3 - 2;
            }
            System.out.println(total);
        } catch (Exception e) {
            System.err.println("Erreur " + e);
        }
    }
}