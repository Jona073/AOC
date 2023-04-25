package A2016.Day3;

import java.io.BufferedReader;
import java.io.FileReader;

public class Ex2 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/java/A2016/Day3/input.txt"))) {
            String line;
            int countTriangle = 0;

            int compteur = 0;
            int[] triangle1 = new int[3];
            int[] triangle2 = new int[3];
            int[] triangle3 = new int[3];
            while ((line = br.readLine()) != null) {
                String[] lstcote = line.trim().split("\\s+");

                triangle1[compteur] = Integer.parseInt(lstcote[0]);
                triangle2[compteur] = Integer.parseInt(lstcote[1]);
                triangle3[compteur] = Integer.parseInt(lstcote[2]);

                compteur++;
                if (compteur == 3) {
                    Triangle t1 = new Triangle(triangle1[0],triangle1[1],triangle1[2]);
                    Triangle t2 = new Triangle(triangle2[0],triangle2[1],triangle2[2]);
                    Triangle t3 = new Triangle(triangle3[0],triangle3[1],triangle3[2]);
                    if (t1.isPossible()) {
                        countTriangle++;
                    }
                    if (t2.isPossible()) {
                        countTriangle++;
                    }
                    if (t3.isPossible()) {
                        countTriangle++;
                    }
                    compteur = 0;
                }

            }
            System.out.println(countTriangle);

        } catch (Exception e) {
        System.err.println("Erreur");
    }
    }
}
