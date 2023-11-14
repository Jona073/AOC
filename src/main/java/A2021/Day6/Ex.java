package A2021.Day6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ex {
    public static void main(String[] args) throws IOException {
        String line;
        final int days = 80;
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/java/A2021/Day6/input.txt"))) {
            line = br.readLine();
        }
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(line);
        List<Lanternfish> lanternfishs = new ArrayList<>();

        matcher.results()
                .map(MatchResult::group)
                .map(Integer::parseInt)
                .forEach(timer -> lanternfishs.add(new Lanternfish(timer)));

        for (int i = 0; i < days; i++) {
            List<Lanternfish> saveLanternfishs = new ArrayList<>(lanternfishs);
            for (Lanternfish lanternfish: saveLanternfishs) {
                Optional<Lanternfish> optionalNewBorn = lanternfish.newDay();
                optionalNewBorn.ifPresent(lanternfishs::add);
            }
        }
        System.out.println(lanternfishs.size());
    }
}
