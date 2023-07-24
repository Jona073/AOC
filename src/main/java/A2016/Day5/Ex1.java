package A2016.Day5;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Ex1 {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        String input = "uqwqemis";
        StringBuilder code = new StringBuilder();
        int number = 0;
        StringBuilder chaine = new StringBuilder(input);
        chaine.append(number);
        String result = MD5(chaine.toString());

        for (int i = 0; i < 8; i++) {
            while (!"00000".equals(result.substring(0, 5))) {
                number++;
                chaine.delete(input.length(), chaine.length());
                chaine.append(number);
                result = MD5(chaine.toString());
            }
            code.append(result.charAt(5));

            number++;
            chaine.delete(input.length(), chaine.length());
            chaine.append(number);
            result = MD5(chaine.toString());
        }

        System.out.println(code.toString());
    }

    public static String MD5(String txt) throws NoSuchAlgorithmException {
        MessageDigest m = MessageDigest.getInstance("MD5");
        byte[] digest = m.digest(txt.getBytes());
        BigInteger bigInt = new BigInteger(1,digest);
        StringBuilder hashtext = new StringBuilder(bigInt.toString(16));
        while(hashtext.length() < 32 ){
            hashtext.insert(0, "0");
        }
        return hashtext.toString();
    }
}
