package A2018.Day1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class EX11 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/java/A2018/Day1/input.txt"))) {
            String line;
            Map<Character, Integer> map = new HashMap<>();
            int total = 0;
            char signe;
            int nombre;
            map.put('+',0);
            map.put('-',0);
            while ((line = br.readLine()) != null) {
                signe = line.charAt(0);
                nombre = Integer.parseInt(line.substring(1));
                map.put(signe, map.get(signe) + nombre );
            }
            total = map.get('+') - map.get('-');
            System.out.println(total);
        } catch (Exception e) {
            System.err.println("Erreur " + e);
        }

    }
}
