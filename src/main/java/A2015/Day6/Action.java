package A2015.Day6;

import java.util.Arrays;

public enum Action {
    TURN_ON("turn on"),
    TURN_OFF("turn off"),
    TOGGLE("toggle");


    private final String label;

    Action(String label) {
        this.label = label;
    }

    public static Action get(String label) {
        return Arrays.stream(values())
                .filter(action -> action.label.equals(label))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Aucune Action ne correspond au label : " + label));
    }
}
