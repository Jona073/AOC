package A2016.Day6;

import lombok.Data;

@Data
public class Signal {
    private String onde;

    public Signal(String input) {
        this.onde = input;
    }
}
