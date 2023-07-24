package A2018.Day5;

import java.io.BufferedReader;
import java.io.FileReader;

public class Ex1 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/java/A2018/Day5/input.txt"))) {
            StringBuilder line = new StringBuilder(br.readLine());
            boolean action;
            do {
                action = false;
                for (int i = 0; i < line.length()-1; i++) {
                    if ((Character.isLowerCase(line.charAt(i)) && Character.isUpperCase(line.charAt(i+1)) && line.charAt(i) == Character.toLowerCase(line.charAt(i+1)))
                      || (Character.isUpperCase(line.charAt(i)) && Character.isLowerCase(line.charAt(i+1)) && line.charAt(i) == Character.toUpperCase(line.charAt(i+1)))
                    ) {
                        line.deleteCharAt(i+1);
                        line.deleteCharAt(i);
                        action = true;
                        break;
                    }
                }
            } while(action);

            System.out.println(line.length());

        } catch (Exception e) {
            System.err.println("Erreur" + e);
        }
    }
}
