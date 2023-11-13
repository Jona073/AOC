package A2017.Day6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Ex1 {
    public static void main(String[] args) throws IOException {
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/java/A2017/Day6/input.txt"))) {
            line = br.readLine();
        }
        Bank bank = new Bank(line);
        System.out.println(bank.computeNumberCycle());
        System.out.println(bank.computeNumberLoop());

    }
}
