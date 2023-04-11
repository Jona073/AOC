package A2016.Day3;

import java.io.BufferedReader;
import java.io.FileReader;

public class Ex1 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/java/A2016/Day3/input.txt"))) {
            String line;
            int countTriangle = 0;
            while ((line = br.readLine()) != null) {
                Triangle triangle = new Triangle(line);
                if (triangle.isPossible()) {
                    countTriangle++;
                }
            }
            System.out.println(countTriangle);

        } catch (Exception e) {
        System.err.println("Erreur");
    }
    }
}
