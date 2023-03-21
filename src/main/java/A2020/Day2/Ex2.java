package A2020.Day2;
import java.io.BufferedReader;
import java.io.FileReader;

public class Ex2 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/java/A2020/Day2/input.txt"))) {
            String line;
            int total = 0;
            int nbCarMin;
            int nbCarMax;
            int nbCar;
            char car;
            while ((line = br.readLine()) != null) {
                nbCar = 0;
                nbCarMin = Integer.parseInt(line.split("-")[0]);
                nbCarMax = Integer.parseInt((line.split("-")[1]).split(" ")[0]);
                car = line.split(":")[0].split(" ")[1].charAt(0);

                char c1 = line.split(": ")[1].charAt(nbCarMin - 1);
                char c2 = line.split(": ")[1].charAt(nbCarMax - 1);
                if (c1 != c2 && (c1 == car || c2 == car)) {
                    total ++;
                }
            }
            System.out.println(total);
        } catch (Exception e) {
            System.err.println("Erreur " + e);
        }
    }
}