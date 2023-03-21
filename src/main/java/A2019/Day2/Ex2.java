package A2019.Day2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Ex2 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/java/A2019/Day2/input.txt"))) {
            String line;
            line = br.readLine();


            int verb = 0;
            int nom;
            boolean exit = false;
            for (nom = 0 ; nom<100 ; nom++) {
                for (verb = 0; verb<100 ; verb++) {
                    if (computer(line,verb,nom) == 19690720) {
                        System.out.println("nom : " + verb + " verb : " + nom +  " valeur : " + computer(line,verb,nom));
                        exit = true;
                        break;
                    }
                }
                if (exit) {
                    break;
                }
            }


            System.out.println(100 * verb + nom);
        } catch (Exception e) {
            System.err.println("Erreur " + e);
        }
    }

    static int computer(String line, int verb, int nom) {
        List<Integer> lstNb =  Arrays.asList(line.split(",")).stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        boolean exit = false;

        lstNb.set(1,verb);
        lstNb.set(2,nom);

        for (int i = 0; i < lstNb.size(); i++) {
            switch (lstNb.get(i)) {
                //Addition
                case 1:
                    lstNb.set(lstNb.get(i+3), (lstNb.get(lstNb.get(i+1)) + lstNb.get(lstNb.get(i+2))));
                    i += 3;
                    break;
                //Multiplication
                case 2:
                    lstNb.set(lstNb.get(i+3), (lstNb.get(lstNb.get(i+1)) * lstNb.get(lstNb.get(i+2))));
                    i +=3;
                    break;
                case 99:
                    exit = true;
                    break;
                default:
                    throw new RuntimeException("Problème code : "  + i);

            }
            if (exit) {
                break;
            }
        }
        return lstNb.get(0);
    }
}


