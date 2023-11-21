package A2021.Day6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ex2 {
    public static void main(String[] args) throws IOException {
        String line;
        final int days = 256;
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/java/A2021/Day6/input.txt"))) {
            line = br.readLine();
        }
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(line);
        LanternfishFamily lanternfishFamily = new LanternfishFamily();
        matcher.results()
                .map(MatchResult::group)
                .map(Integer::parseInt)
                .forEach(timer -> lanternfishFamily.getLanternfishs().merge(timer,1L,Long::sum));


        for (int i = 0; i < days; i++) {
            lanternfishFamily.nextDay();
        }
        System.out.println(lanternfishFamily.computeSizeFamily());






    }


}
