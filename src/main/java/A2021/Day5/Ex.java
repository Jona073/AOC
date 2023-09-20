package A2021.Day5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Ex {
    public static void main(String[] args) throws IOException {
        String line;
        Diagram diagram = new Diagram();
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/java/A2021/Day5/input.txt"))) {
        while ((line = br.readLine()) != null) {
            diagram.addSegment(new Segment(line));
        }
    }

        System.out.println(diagram.computeNodesNumber());

    }
}
