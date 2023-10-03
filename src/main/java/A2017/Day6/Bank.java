package A2017.Day6;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Data
public class Bank {
    List<Integer> boxBox =new ArrayList<>();
    List<List<Integer>> memories = new ArrayList<>();

    public Bank(String input) {
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
            int box = Integer.parseInt(matcher.group());
            this.boxBox.add(box);
        }
        saveBank();
    }

    private void saveBank() {
        List<Integer> numbers = new ArrayList<>();
        for (int number : this.boxBox) {
            numbers.add(number);
        }
        this.memories.add(numbers);
    }

    public int computeNumberCycle() {
        int count = 0;
        while(count < Integer.MAX_VALUE) {
            moveBox();
            count++;
            if (isBoxAlreadySeen()) {
                saveBank();
                return count;
            }
            saveBank();
        }
        return -1;
    }
    
    public int computeNumberLoop() {
        int count = 0;
        while(count < Integer.MAX_VALUE) {
            moveBox();
            count++;
            if (isTheBeginLoop()) {
                return count;
            }
        }
        return -1;
    }

    private boolean isBoxAlreadySeen() {
        for (List<Integer> numbers : this.memories) {
            if(numbers.equals(this.boxBox)) {
                return true;
            }
        }
        return false;
    }
    private boolean isTheBeginLoop() {
        return this.boxBox.equals(this.memories.get(this.memories.size()-1));
    }

    private void moveBox() {
        int max = this.boxBox.stream().max(Integer::compareTo).orElse(0);
        int index = this.boxBox.indexOf(max);
        int size = this.boxBox.size();
        this.boxBox.set(index,0);
        index++;
        for (int i = 0; i < max; i++) {
            if (index >= size) {
                index = 0;
            }
            int number = this.boxBox.get(index);
            this.boxBox.set(index, number+1);
            index++;
        }
    }

}
