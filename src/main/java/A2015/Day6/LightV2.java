package A2015.Day6;

import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class LightV2 {
    private int brightness;

    public LightV2() {
        this.brightness = 0;
    }

    public void switchLight() {
        this.brightness += 2;
    }
    public void turnOn() {
        this.brightness +=1;
    }
    public void turnOff() {
        if (this.brightness !=0) {
            this.brightness-=1;
        }
    }
}
