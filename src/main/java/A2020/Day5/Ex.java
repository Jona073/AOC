package A2020.Day5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Ex {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("src/main/java/A2020/Day5/input.txt"));
        String line;
        int maxSeatID = Integer.MIN_VALUE;
        while ((line = br.readLine()) != null) {
            BoardingPasses boardingPasses = new BoardingPasses(line);
            if (boardingPasses.getID() > maxSeatID) {
                maxSeatID = boardingPasses.getID();
            }

        }
        System.out.println(maxSeatID);

        br.close();
    }


}
