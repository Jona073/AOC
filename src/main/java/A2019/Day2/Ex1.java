package A2019.Day2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Ex1 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/java/A2019/Day2/input.txt"))) {
            String line;
            line = br.readLine();
            List<Integer> lstNb =  Arrays.stream(line.split(","))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            boolean exit = false;


            lstNb.set(1,12);
            lstNb.set(2,2);

            for (int i = 0; i < lstNb.size(); i+=4) {
                switch (lstNb.get(i)) {
                    //Addition
                    case 1:
                        lstNb.set(lstNb.get(i+3), (lstNb.get(lstNb.get(i+1)) + lstNb.get(lstNb.get(i+2))));
                        break;
                    //Multiplication
                    case 2:
                        lstNb.set(lstNb.get(i+3), (lstNb.get(lstNb.get(i+1)) * lstNb.get(lstNb.get(i+2))));
                    break;
                    case 99:
                        exit = true;
                    break;
                    default:
                        throw new IllegalArgumentException("Problème code");

                }
                if (exit) {
                    break;
                }
            }
            int result = lstNb.get(0);
            System.out.println(result);
        } catch (Exception e) {
            System.err.println("Erreur " + e);
        }
    }
}
