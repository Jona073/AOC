package A2016.Day6;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

import static java.util.Map.Entry.comparingByValue;
import static java.util.stream.Collectors.*;

@Data
public class Radio {
    private List<Signal> signals = new ArrayList<>();
    public void addSignal(String input) {
        this.signals.add(new Signal(input));
    }

    private List<List<Character>> computeAllSignals() {
        List<List<Character>> allSignal = new ArrayList<>();
        for (Signal signal: this.signals) {
            for (int i = 0; i < signal.getOnde().length(); i++) {
                if (allSignal.size() <= i ) {
                    allSignal.add(new ArrayList<>());
                }
                allSignal.get(i).add(signal.getOnde().charAt(i));
            }
        }
        return allSignal;
    }

    public String computeMostCommonCharacter() {
        StringBuilder result = new StringBuilder();
        List<List<Character>> allSignal = computeAllSignals();
        for (List<Character> characters : allSignal) {
            char mostCommon = characters
                    .stream()
                    .collect(groupingBy(x -> x, counting()))
                    .entrySet()
                    .stream()
                    .max(comparingByValue())
                    .orElseThrow()
                    .getKey();
            result.append(mostCommon);
        }

        return result.toString();
    }

    public String computeLeastCommonCharacter() {
        StringBuilder result = new StringBuilder();
        List<List<Character>> allSignal = computeAllSignals();
        for (List<Character> characters : allSignal) {
            char leastCommon = characters
                    .stream()
                    .collect(groupingBy(x -> x, counting()))
                    .entrySet()
                    .stream()
                    .min(comparingByValue())
                    .orElseThrow()
                    .getKey();
            result.append(leastCommon);
        }

        return result.toString();
    }
}
