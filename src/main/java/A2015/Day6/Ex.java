package A2015.Day6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Ex {
    public static void main(String[] args) throws IOException {
        int count = 0;
        Parc parc = new Parc();
        try(BufferedReader br = new BufferedReader(new FileReader("src/main/java/A2015/Day6/input.txt"))) {
            String line;
            while((line = br.readLine()) != null) {
                parc.action(line);
            }
        }

        System.out.println(parc.computeLightOn());
        System.out.println(parc.computeLightV2On());
    }
}
