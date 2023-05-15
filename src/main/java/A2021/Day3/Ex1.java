package A2021.Day3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Ex1 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/java/A2021/Day3/input.txt"))) {
            String line;
            List<String> bits = new ArrayList<>();
            while ((line = br.readLine()) != null) {
                bits.add(line);
            }

            String resGamma = gamma(bits);
            System.out.println("Gamme : " + resGamma);
            String resEpsilon = epsilon(bits);
            System.out.println("Epsilon : " + resEpsilon);
            int result = Integer.parseInt(resEpsilon,2) * Integer.parseInt(resGamma,2);
            System.out.println(result);

            System.out.println(" oxygen : " + oxygen(bits,0));
            System.out.println(" co2 : " + co2(bits,0));

            System.out.println(Integer.parseInt(oxygen(bits,0),2) * Integer.parseInt(co2(bits,0),2));



        } catch (Exception e) {
            System.err.println("Erreur " + e);
        }
    }

    public static int[] tabNumberOf1(List<String> bits) {
        int lenghtLine = bits.get(0).length();
        int[] numberOf1 = new int[lenghtLine];
        for (String bit :
                bits) {
            for (int i = 0; i < bit.length(); i++) {
                if (bit.charAt(i) == '1') {
                    numberOf1[i] += 1;
                }
            }
        }

        return numberOf1;
    }

    public static String gamma(List<String> bits) {
        StringBuilder resGamma = new StringBuilder();
        int lenghtLine = bits.get(0).length();
        int lenghtList = bits.size();

        int[] numberOf1 = tabNumberOf1(bits);

        for (int i = 0; i < lenghtLine; i++) {
            if (numberOf1[i] >= Math.round((float)lenghtList/2)) {
                resGamma.append("1");
            } else {
                resGamma.append("0");
            }
        }
        return resGamma.toString();
    }

    public static String epsilon(List<String> bits) {
        StringBuilder resGamma = new StringBuilder();
        int[] numberOf1 = tabNumberOf1(bits);
        int lenghtLine = bits.get(0).length();
        int lenghtList = bits.size();

        for (int i = 0; i < lenghtLine; i++) {
            if (numberOf1[i] < Math.round((float)lenghtList/2)) {
                resGamma.append("1");
            } else {
                resGamma.append("0");
            }
        }
        return resGamma.toString();
    }

    public static String oxygen(List<String> bits, int pos) {
        List<String> bitsCopy = new ArrayList<>(bits);
        String resGamma = gamma(bitsCopy);
        for (String bit :
                bits) {
            if(bit.charAt(pos) != resGamma.charAt(pos)) {
                bitsCopy.remove(bit);
            }
        }

        if (bitsCopy.size() == 1) {
            return bitsCopy.get(0);
        } else {
            return oxygen(bitsCopy,pos + 1);
        }
    }

    public static String co2(List<String> bits, int pos) {
        List<String> bitsCopy = new ArrayList<>(bits);
        String resEpsilon = epsilon(bitsCopy);
        for (String bit :
                bits) {
            if(bit.charAt(pos) != resEpsilon.charAt(pos)) {
                bitsCopy.remove(bit);
            }
        }

        if (bitsCopy.size() == 1) {
            return bitsCopy.get(0);
        } else {
            return co2(bitsCopy,pos + 1);
        }
    }



}
