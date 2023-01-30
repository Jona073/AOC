package A2018.Day2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Ex2 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/java/A2018/Day2/input.txt"))) {
            String line;
            int total;
            int count;
            String code = "";
            List<String> lstTexte = new ArrayList<>();
            String txt1 ="";
            String txt2;
            while ((line = br.readLine()) != null) {
                for (int i = 1; i < line.length(); i++) {
                    for (String chaine2: lstTexte) {
                        txt1 = line.substring(0,i) + line.substring(i+1);
                        txt2 = chaine2.substring(0,i) + chaine2.substring(i+1);
                        if (txt1.equals(txt2)) {
                            code = txt1;
                            break;
                        }
                    }
                }
                lstTexte.add(line);
            }
            System.out.println(code);
        } catch (Exception e) {
            System.err.println("Erreur " + e);
        }
    }
}
