package A2019.Day6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Ex1 {
    public static void main(String[] args) throws IOException {
        List<Planet> planets = new ArrayList<>();
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/java/A2019/Day6/input.txt"))) {
            while ((line = br.readLine()) != null) {
                String[] tabPlanet = line.split("\\)");
                Planet planet1 = new Planet(tabPlanet[0]);
                Planet planet2 = new Planet(tabPlanet[1]);
                planet2.setOrbit(planet1);
                if(planet1.getName().equals("XNR") || planet2.getName().equals("XNR") ) {
                    System.out.println("tst");
                }
                if (planets.contains(planet1)) {
                    planet1 = planets.get(planets.indexOf(planet1));
                    planet2.setOrbit(planet1);
                } else {
                    planets.add(planet1);
                }
                if (planets.contains(planet2)) {
                    planets.set(planets.indexOf(planet2),planet2);
                    for (Planet p : planets) {
                        if(p.getOrbit() != null && p.getOrbit().equals(planet2)) {
                            p.setOrbit(planet2);
                        }
                    }
                } else {
                    planets.add(planet2);
                }


            }
        }
//        int directOrbit = (int) planets.stream()
//                .filter(p -> p.getOrbit() != null)
//                .count();
//        System.out.println(directOrbit);

        int countObit = planets.stream()
                .mapToInt(Planet::computeIndirectOrbite)
                .sum();
        System.out.println(countObit);

        Planet you = planets.get(planets.indexOf(new Planet("YOU")));
        Planet san = planets.get(planets.indexOf(new Planet("SAN")));

        int distance = you.distanceFromPlanet(san);
        System.out.println(distance);

    }


}
