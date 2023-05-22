package A2015.Day4;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Ex1 {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        String input = "iwrupvqb";
        int number = 0;
        StringBuilder chaine = new StringBuilder(input);
        chaine.append(number);
        String result = MD5(chaine.toString());
        //Partie 1
        while (!"00000".equals(result.substring(0,5))) {
            number++;
            chaine.delete(input.length(),chaine.length());
            chaine.append(number);
            result = MD5(chaine.toString());
        }
        System.out.println(number);

        //Partie 2
        while (!"000000".equals(result.substring(0,6))) {
            number++;
            chaine.delete(input.length(),chaine.length());
            chaine.append(number);
            result = MD5(chaine.toString());
        }
        System.out.println(number);
    }


    public static String MD5(String txt) throws NoSuchAlgorithmException {
        MessageDigest m = MessageDigest.getInstance("MD5");
        m.reset();
        m.update(txt.getBytes());
        byte[] digest = m.digest();
        BigInteger bigInt = new BigInteger(1,digest);
        StringBuilder hashtext = new StringBuilder(bigInt.toString(16));
        while(hashtext.length() < 32 ){
            hashtext.insert(0, "0");
        }
        return hashtext.toString();
    }
}
