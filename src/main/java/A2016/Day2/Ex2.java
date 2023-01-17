package A2016.Day2;

import java.io.BufferedReader;
import java.io.FileReader;

public class Ex2 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/java/A2016/Day2/Code.txt"))) {
            String line;
            char[] tabKeyboard = {'N','N','1','N','N','N','2','3','4','N','5','6','7','8','9','N','A','B','C','N','D','N','N'};
            int pos = 10;
            String code = "";
            while ((line = br.readLine()) != null) {
                char[] tabDir = line.toCharArray();
                for (char dir:tabDir) {
                    switch (dir) {
                        case 'U':
                            if(pos - 5 >= 0  && tabKeyboard[pos-1] != 'N') {
                                pos -=5;
                            }
                            break;
                        case 'D':
                            if (pos + 5 < tabKeyboard.length  && tabKeyboard[pos+5] != 'N' ) {
                                pos += 5;
                            }
                            break;
                        case 'L':
                            if (pos % 5 != 0 && tabKeyboard[pos-1] != 'N') {
                                pos -= 1;
                            }
                            break;
                        case 'R':
                            if (pos % 5 != 2 && tabKeyboard[pos+1] != 'N') {
                                pos += 1;
                            }
                            break;
                        default:
                            throw new RuntimeException();
                    }
                    if (pos > 8)
                    {
                        pos = pos;
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
