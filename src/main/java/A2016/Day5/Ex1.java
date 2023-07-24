package A2016.Day5;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Ex1 {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        String input = "uqwqemis";
        StringBuilder code = new StringBuilder();
        char[] code2 = new char[8];
        code2[0] = '_';
        code2[1] = '_';
        code2[2] = '_';
        code2[3] = '_';
        code2[4] = '_';
        code2[5] = '_';
        code2[6] = '_';
        code2[7] = '_';

        int number = 0;
        StringBuilder chaine = new StringBuilder(input);
        chaine.append(number);
        String result = MD5(chaine.toString());

//        for (int i = 0; i < 8; i++) {
//            while (!"00000".equals(result.substring(0, 5))) {
//                number++;
//                chaine.delete(input.length(), chaine.length());
//                chaine.append(number);
//                result = MD5(chaine.toString());
//            }
//            code.append(result.charAt(5));
//
//            number++;
//            chaine.delete(input.length(), chaine.length());
//            chaine.append(number);
//            result = MD5(chaine.toString());
//        }

        while (code2[0] == '_' || code2[1] == '_' || code2[2] == '_' || code2[3] == '_' || code2[4] == '_' || code2[5] == '_' || code2[6] == '_' || code2[7] == '_' ) {
            while (!"00000".equals(result.substring(0, 5))) {
                number++;
                chaine.delete(input.length(), chaine.length());
                chaine.append(number);
                result = MD5(chaine.toString());
            }
            char position = result.charAt(5);
            if (position >= '0' && position <'8') {
                if(code2[Character.getNumericValue(position)] == '_') {
                    code2[Character.getNumericValue(position)] = result.charAt(6);
                }
            }
            number++;
            chaine.delete(input.length(), chaine.length());
            chaine.append(number);
            result = MD5(chaine.toString());
        }

        code.append(code2[0]);
        code.append(code2[1]);
        code.append(code2[2]);
        code.append(code2[3]);
        code.append(code2[4]);
        code.append(code2[5]);
        code.append(code2[6]);
        code.append(code2[7]);

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
