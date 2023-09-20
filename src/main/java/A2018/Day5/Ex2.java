package A2018.Day5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashSet;
import java.util.Set;

public class Ex2 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/java/A2018/Day5/input.txt"))) {
            StringBuilder line = new StringBuilder(br.readLine());



            System.out.println(scannedPolymer(line));
            System.out.println(getMinScannedPolymer(line));

        } catch (Exception e) {
            System.err.println("Erreur" + e);
        }
    }

    private static int scannedPolymer(StringBuilder line) {
        StringBuilder input = new StringBuilder(line);
        boolean action;
        do {
            action = false;
            for (int i = 0; i < input.length()-1; i++) {
                if ((Character.isLowerCase(input.charAt(i)) && Character.isUpperCase(input.charAt(i+1)) && input.charAt(i) == Character.toLowerCase(input.charAt(i+1)))
                  || (Character.isUpperCase(input.charAt(i)) && Character.isLowerCase(input.charAt(i+1)) && input.charAt(i) == Character.toUpperCase(input.charAt(i+1)))
                ) {
                    input.deleteCharAt(i+1);
                    input.deleteCharAt(i);
                    action = true;
                    break;
                }
            }
        } while(action);
        return input.length();
    }

    private static StringBuilder removePolymer(StringBuilder line, char carac) {
        String input = line.toString().replace(Character.toString(Character.toUpperCase(carac)),"");
        input = input.replace(Character.toString(Character.toLowerCase(carac)),"");
        return new StringBuilder(input);
    }

    private static Set<Character> getLowerPolymer(StringBuilder line) {
        Set<Character> lstCarac = new HashSet<>();
        for (char car : line.toString().toCharArray()) {
            lstCarac.add(Character.toLowerCase(car));
        }
        return lstCarac;
    }

    private static int getMinScannedPolymer(StringBuilder line) {
        int minPolymer = Integer.MAX_VALUE;
        int countPolymer;
        for (Character carac : getLowerPolymer(line)) {
            countPolymer = scannedPolymer(removePolymer(line,carac));
            if (minPolymer > countPolymer) {
                minPolymer = countPolymer;
            }
        }
        return minPolymer;
    }

}
