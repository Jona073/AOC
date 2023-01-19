package A2017.Day1;

import java.io.BufferedReader;
import java.io.FileReader;

public class Ex1 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/java/A2017/Day1/suite.txt"))) {
            char[] line = br.readLine().toCharArray();
            int tt = 0;
            for (int i = 0; i < line.length; i++) {
                if (i+1 < line.length) {
                    if (Character.getNumericValue(line[i]) == Character.getNumericValue(line[i+1])) {
                        tt += Character.getNumericValue(line[i]);
                    }
                } else {
                    if(Character.getNumericValue(line[i]) == Character.getNumericValue(line[0])) {
                        tt += Character.getNumericValue(line[i]);
                    }
                }
            }

            System.out.println("Code : " + tt);

        } catch (Exception e) {
            System.err.println("Erreur");
        }
    }
}
