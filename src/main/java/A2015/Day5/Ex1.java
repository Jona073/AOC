package A2015.Day5;

import java.io.BufferedReader;
import java.io.FileReader;

public class Ex1 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/java/A2015/Day5/input.txt"))) {
            String line;
            int count = 0;

            while ((line = br.readLine()) != null) {
//                if (isNice(line)) {
//                    count++;
//                }
                if(isRealGoodChain(line)) {
                    count++;
                }
            }
            System.out.println(count);

        } catch (Exception e) {
            System.err.println("Erreur");
        }


    }
    public static boolean isNice(String input) {
        return hasDouble(input) && threeVowels(input) && notBadChain(input);
    }


    public static boolean hasDouble(String input) {
        char precChar = ' ';
        for (char c : input.toCharArray()) {
            if(precChar == c) {
                return true;
            }
            precChar = c;
        }
        return false;
    }

    public static boolean threeVowels(String input) {
        int numVowels = 0;
        for (char carac : input.toCharArray()) {
            if ("aeiou".contains(String.valueOf(carac))) {
                numVowels++;
            }
        }
        return numVowels >=3;
    }

    public static boolean notBadChain(String input) {
        return !input.contains("ab") && !input.contains("cd") && !input.contains("pq") && !input.contains("xy");
    }

    public static boolean hasPair(String input) {
        for (int i = 0; i < input.length()-2; i++) {
            String pair = input.substring(i,i+2);
            if (input.substring(i+2).contains(pair)) {
                return true;
            }
        }
        return false;
    }

    public static boolean hasDoubleSeparate(String input) {
        for (int i = 0; i < input.length() - 2; i++) {
            if(input.charAt(i) == input.charAt(i+2)) {
                return true;
            }
        }

        return false;
    }

    public static boolean isRealGoodChain(String input) {
        return hasDoubleSeparate(input) && hasPair(input);
    }


}
