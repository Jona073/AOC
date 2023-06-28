package A2020.Day4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Ex1 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/java/A2020/Day4/input.txt"))) {
            String line;
            List<String> peoples = new ArrayList<>();
            StringBuilder person = new StringBuilder();
            int count = 0;
            while ((line = br.readLine()) != null) {
                    if (!"".equals(line)) {
                        person.append(line);
                        person.append(" ");
                    } else {
                        peoples.add(person.toString());
                        person = new StringBuilder();
                    }
                }
            peoples.add(person.toString());

            for (String people: peoples) {
                Passeport passeport = new Passeport(people);
                if (passeport.isValidV2()) {
                    count++;
                }
            }
            System.out.println(count);

        } catch (Exception e) {
            System.err.println("Erreur " + e);
        }
    }
}