package A2019.Day1;
import java.io.BufferedReader;
import java.io.FileReader;
public class Ex2 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/java/A2019/Day1/input.txt"))) {
            String line;
            int total = 0;
            int nb;
            while ((line = br.readLine()) != null) {
                nb = Integer.parseInt(line) / 3 - 2;
                while (nb>0) {
                    total += nb;
                    nb = nb / 3 - 2;
                }
            }
            System.out.println(total);
        } catch (Exception e) {
            System.err.println("Erreur " + e);
        }
    }
}