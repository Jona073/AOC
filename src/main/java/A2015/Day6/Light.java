package A2015.Day6;

import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class Light {
    private boolean etat;

    public Light() {
        this.etat = false;
    }

    public void switchLight() {
        this.etat = !this.etat;
    }
    public void turnOn() {
        this.etat = true;
    }
    public void turnOff() {
        this.etat = false;
    }
}
