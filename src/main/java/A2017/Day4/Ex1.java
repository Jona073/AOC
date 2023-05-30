package A2017.Day4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Ex1 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/java/A2017/Day4/input.txt"))) {
            String line;
            int result = 0;
            boolean isOk;
            while ((line = br.readLine()) != null) {
                Set<String> listWord = new HashSet<>();
                isOk = true;
                for (String word :
                        line.split(" ")) {
                    if (!listWord.add(word)) {
                        isOk = false;
                        break;
                    }
                }
                if (isOk) {
                    result++;
                }

                //EX 2
                List<List<Character>> listCharWord = new ArrayList<>();
                for (String word :
                        line.split(" ")) {
                    listCharWord.add(word.toCharArray());
                    if () {
                        isOk = false;
                        break;
                    }
                }

            }

            System.out.println(result);
        } catch (Exception e) {
            System.err.println("Erreur" + e);
        }

    }
}

