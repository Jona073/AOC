package A2020.Day3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.math.BigInteger;

public class Ex1 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/java/A2020/Day3/input.txt"))) {
            String line;
            int y = 0;
            Forest forest = new Forest();
            while ((line = br.readLine()) != null) {
                forest.addLineTree(line, y);
                y++;
            }

            Person person1 = new Person();
            Person person2 = new Person();
            Person person3 = new Person();
            Person person4 = new Person();
            Person person5 = new Person();

            person1.toboggan(1, 1, forest);
            person2.toboggan(3, 1, forest);
            person3.toboggan(5, 1, forest);
            person4.toboggan(7, 1, forest);
            person5.toboggan(1, 2, forest);

            BigInteger p1 = BigInteger.valueOf(person1.getNumberHit());
            BigInteger p2 = BigInteger.valueOf(person2.getNumberHit());
            BigInteger p3 = BigInteger.valueOf(person3.getNumberHit());
            BigInteger p4 = BigInteger.valueOf(person4.getNumberHit());
            BigInteger p5 = BigInteger.valueOf(person5.getNumberHit());

            BigInteger result = p1.multiply(p2).multiply(p3).multiply(p4).multiply(p5);

            System.out.println(person2.getNumberHit());
            System.out.println(result);


        } catch (Exception e) {
            System.err.println("Erreur " + e);
        }
    }
}
