package A2017.Day1;

import java.io.BufferedReader;
import java.io.FileReader;

public class Ex2 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/java/A2017/Day1/suite.txt"))) {
            char[] line = br.readLine().toCharArray();
            //char[] line = {'1','2','1','2'};
            int tt = 0;
            for (int i = 0; i < line.length/2; i++) {
                if (i+1 < line.length/2) {
                    if (Character.getNumericValue(line[i]) == Character.getNumericValue(line[i+ (line.length/2)])) {
                        tt += Character.getNumericValue(line[i])*2;
                    }
                } else {
                    if(Character.getNumericValue(line[i]) == Character.getNumericValue(line[line.length -1])) {
                        tt += Character.getNumericValue(line[i])*2;
                    }
                }
            }

            System.out.println("Code : " + tt);

        } catch (Exception e) {
            System.err.println("Erreur");
        }
    }
}
