package A2021.Day4;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Line {
    List<Integer> numbers;
    int checkNumber;

    public Line() {
        this.numbers = new ArrayList<>();
        this.checkNumber = 0;
    }

    public Line(List<Integer> lstNumbers) {
        this.numbers = new ArrayList<>();
        this.numbers.addAll(lstNumbers);
        this.checkNumber = 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Line)) return false;
        Line line = (Line) o;
        return this.getNumbers().containsAll(line.getNumbers());
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers, checkNumber);
    }

    public List<Integer> getNumbers() {
        return new ArrayList<>(numbers);
    }

    public List<Integer> uncheckNumber(List<Integer> checkNumber) {
        List<Integer> lstUncheckNumbmer = new ArrayList<>();
        for (Integer num : this.numbers) {
            if (!checkNumber.contains(num))
                lstUncheckNumbmer.add(num);
        }
        return lstUncheckNumbmer;
    }

    public int getCountCheckNumber() {
        return checkNumber;
    }
    
    public void newNumber(int number) {
        if(this.numbers.contains(number))
            this.checkNumber +=1;
    }
}
