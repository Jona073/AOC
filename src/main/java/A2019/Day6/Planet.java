package A2019.Day6;

import lombok.Data;

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



}
