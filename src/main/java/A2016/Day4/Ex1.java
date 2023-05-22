package A2016.Day4;

import java.io.BufferedReader;
import java.io.FileReader;

public class Ex1 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/java/A2016/Day4/input.txt"))) {
            String line;
            int result = 0;
            int resultEx2 = 0;
            while ((line = br.readLine()) != null) {
                Room room = new Room(line);
                if (room.isReal()) {
                    result += room.getId();
                }
                if(room.decrypt().contains("northpole")) {
                    resultEx2 = room.getId();
                }
            }

            System.out.println(result);
            System.out.println(resultEx2);
        } catch (Exception e) {
            System.err.println("Erreur" + e);
        }

    }
}

