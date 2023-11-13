package A2021.Day6;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Optional;

@Data
@AllArgsConstructor
public class Lanternfish {
    private int timer;

    public Optional<Lanternfish> newDay(){
        Optional<Lanternfish> optionalLanternfish = Optional.empty();
        if (this.timer == 0) {
            optionalLanternfish = Optional.of(new Lanternfish(8));
            this.timer = 6;
        } else {
            this.timer--;
        }
        return optionalLanternfish;
    }
}
