package A2021.Day6;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Optional;

@Data
@AllArgsConstructor
public class Lanternfish {
    private int timer;
    private static final int CYCLE_NEW_BORN = 8;
    private static final int CYCLE_NEXT_CYCLE = 6;

    public Optional<Lanternfish> newDay(){
        Optional<Lanternfish> optionalNewBorn = Optional.empty();
        if (this.timer == 0) {
            optionalNewBorn = Optional.of(new Lanternfish(CYCLE_NEW_BORN));
            this.timer = CYCLE_NEXT_CYCLE;
        } else {
            this.timer--;
        }
        return optionalNewBorn;
    }
}
