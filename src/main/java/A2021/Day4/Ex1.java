package A2021.Day4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Ex1 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/java/A2021/Day4/input.txt"))) {
            String line;
            //Lire la 1ere ligne pour numero + 2éme ligne vide
            String input = br.readLine();
            List<Integer> lstNumber = Arrays.asList(input.split(",")).stream().map(Integer::parseInt).collect(Collectors.toList());

            br.readLine();
            List<Planche> planches = new ArrayList<>();
            Planche planche = new Planche();
            while ((line = br.readLine()) != null) {
                if (!"".equals(line)) {
                    Line l1 = new Line(Arrays.asList(line.split(" ")).stream().filter(s -> !"".equals(s)).map(Integer::parseInt).collect(Collectors.toList()));
                    planche.addLine(l1);
                } else {
                    planches.add(planche);
                    planche = new Planche();
                }
            }
            planches.add(planche);

            //EX 1
            // boolean win = false;
            // List<Integer> lstMarked = new ArrayList<>();
            // for (int number : lstNumber) {
            //     lstMarked.add(number);
            //     for (Planche p: planches) {
            //         p.newNumber(number);
            //         if(p.hasOneLineMarked() ||p.hasOneColumnMarked()) {
            //             System.out.println(number);
            //             System.out.println(p.computeScore(lstMarked));
            //             win = true;
            //             break;
            //         }
            //     }
            //     if (win)
            //         break;
            // }

            //EX2
            List<Planche> notCompletedPlanches = new ArrayList<>(planches);
            boolean last = false;
            List<Integer> lstMarked = new ArrayList<>();
            for (int number : lstNumber) {
                lstMarked.add(number);
                for (Planche p: planches) {
                    p.newNumber(number);
                    if((p.hasOneLineMarked() ||p.hasOneColumnMarked()) && notCompletedPlanches.contains(p)) {
                        if (notCompletedPlanches.size() > 1 ) {
                            notCompletedPlanches.remove(p);
                        } else {
                            System.out.println(number);
                            System.out.println(p.computeScore(lstMarked));
                            last = true;
                            break;
                        }
                    }
                }
                if (last) {
                    break;
                }
            }

        } catch (Exception e) {
            System.err.println("Erreur " + e);
        }
    }
}
