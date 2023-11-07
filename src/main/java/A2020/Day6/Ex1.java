package A2020.Day6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Ex1 {
    public static void main(String[] args) throws IOException {
        List<Group> groupes = new ArrayList<>();
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/java/A2020/Day6/input.txt"))) {
            Group group = new Group();
            while ((line = br.readLine()) != null) {
                if (line.isBlank()) {
                    groupes.add(group);
                    group = new Group();
                } else {
                    group.addPerson(line);
                }
            }
            groupes.add(group);
            group = new Group();
        }
        int result = groupes.stream()
                            .mapToInt(Group::getNumberYes)
                            .sum();

        System.out.println(result);

        result = groupes.stream()
                            .mapToInt(Group::getEveryoneYes)
                            .sum();

        System.out.println(result);

    }
}
