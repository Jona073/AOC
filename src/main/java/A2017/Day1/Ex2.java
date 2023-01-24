package A2017.Day1;

import java.io.BufferedReader;
import java.io.FileReader;

public class Ex2 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/java/A2017/Day1/suite.txt"))) {
            char[] line = br.readLine().toCharArray();
            //char[] line = {'1','2','1','2'};
            int total = 0;
            for (int index = 0; index < line.length/2; index++) {
                if (index+1 < line.length/2) {
                    if (Character.getNumericValue(line[index]) == Character.getNumericValue(line[index+ (line.length/2)])) {
                        total += Character.getNumericValue(line[index])*2;
                    }
                } else {
                    if(Character.getNumericValue(line[index]) == Character.getNumericValue(line[line.length -1])) {
                        total += Character.getNumericValue(line[index])*2;
                    }
                }
            }

            System.out.println("Code : " + total);

        } catch (Exception e) {
            System.err.println("Erreur");
        }
    }
}
