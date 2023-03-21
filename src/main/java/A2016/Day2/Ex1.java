package A2016.Day2;

import java.io.BufferedReader;
import java.io.FileReader;

public class Ex1 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/java/A2016/Day2/Code.txt"))) {
            String line;
            int[] tabKeyboard = {1,2,3,4,5,6,7,8,9};
            int pos = 4;
            String code = "";
            while ((line = br.readLine()) != null) {
                char[] tabDir = line.toCharArray();
                for (char dir:tabDir) {
                    switch (dir) {
                        case 'U':
                            if(pos - 3 >= 0) {
                                pos -=3;
                            }
                            break;
                        case 'D':
                            if (pos + 3 < tabKeyboard.length  ) {
                                pos += 3;
                            }
                            break;
                        case 'L':
                            if (pos % 3 != 0) {
                                pos -= 1;
                            }
                            break;
                        case 'R':
                            if (pos % 3 != 2) {
                                pos += 1;
                            }
                            break;
                        default:
                            throw new IllegalArgumentException("Valeur Impossible : " + dir);
                    }
                }

                code += tabKeyboard[pos];
            }
            System.out.println("Code : " + code);

        } catch (Exception e) {
            System.err.println("Erreur");
        }
    }
}
