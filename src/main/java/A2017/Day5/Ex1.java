package A2017.Day5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class Ex1 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/java/A2017/Day5/input.txt"))) {
            String line;
            int position = 0;
            int step = 0;
            Map<Integer,Integer> numbers = new HashMap<>();

            while ((line = br.readLine()) != null) {
                numbers.put(position,Integer.parseInt(line));
                position++;
            }

            position = 0;
            while(numbers.containsKey(position)) {
                numbers.replace(position,numbers.get(position)+1);
                //Car faut pas prendre en compte l'incrémentation
                position+= numbers.get(position) -1;
                step++;
            }

            System.out.println(step);

        } catch (Exception e) {
            System.err.println("Erreur" + e);
        }
    }
}
