package A2017.Day1;

import java.io.BufferedReader;
import java.io.FileReader;

public class Ex1 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/java/A2017/Day1/suite.txt"))) {
            char[] line = br.readLine().toCharArray();
            int total = 0;
            for (int index = 0; index < line.length - 1; index++) {
                if (line[index] == line[index + 1]) {
                    total += line[index]-'0';
                }
            }
            if (Character.getNumericValue(line[line.length - 1]) == Character.getNumericValue(line[0])) {
                total += Character.getNumericValue(line[0]);
            }
            System.out.println("Code : " + total);
        } catch (Exception e) {
            System.err.println("Erreur");
        }
    }
}
