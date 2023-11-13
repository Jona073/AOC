package A2019.Day6;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
public class Planet {
    private String name;
    private Planet orbit;

    public Planet(String input) {
        this.name = input;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Planet)) return false;
        Planet planet = (Planet) o;
        return Objects.equals(name, planet.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public int computeIndirectOrbite() {
        if (this.getOrbit() == null) {
            return 0;
        }
        else if (this.getOrbit().getName() == null) {
            return 1;
        } else {
            return this.getOrbit().computeIndirectOrbite() + 1;
        }
    }

    public int distanceFromPlanet(Planet planet) {
        List<String> orbits1 = new ArrayList<>();
        Planet currentPlanet = this.getOrbit();
        while (true) {
            orbits1.add(currentPlanet.getName());
            if (currentPlanet.getOrbit() == null) {
                break;
            }
            currentPlanet = currentPlanet.getOrbit();
        }

        List<String> orbits2 = new ArrayList<>();
        currentPlanet = planet.getOrbit();
        while (true) {
            orbits2.add(currentPlanet.getName());
            if (currentPlanet.getOrbit() == null) {
                break;
            }
            currentPlanet = currentPlanet.getOrbit();
        }

        int count =0;
        for (String name : orbits2) {
            int index = orbits1.indexOf(name);
            if(index != -1) {
                count = index + orbits2.indexOf(name);
                break;
            }
        }
        return count;
    }



}
