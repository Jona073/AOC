package A2016.Day6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Ex1 {
    public static void main(String[] args) throws IOException {
        Radio radio = new Radio();
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/java/A2016/Day6/input.txt"))) {
            while ((line = br.readLine()) != null) {
                radio.addSignal(line);
            }
        }
        System.out.println(radio.computeMostCommonCharacter());
        System.out.println(radio.computeLeastCommonCharacter());
    }
}
