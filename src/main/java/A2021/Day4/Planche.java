package A2021.Day4;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Planche {
    private List<Line> lstLine;
    private List<Line> lstColumn;

    public Planche() {
        this.lstLine = new ArrayList<>();
    }

    public void addLine(Line l1) {
        this.lstLine.add(l1);
        this.computeColumn();
    }

    public void addColumn(Line c1) {this.lstColumn.add(c1); }

    public void newNumber(int number) {
        for (Line line : this.lstLine) {
            line.newNumber(number);
        }

        for (Line column : this.lstColumn) {
            column.newNumber(number);
        }
    }

    public boolean hasOneLineMarked() {
        for (Line line : this.lstLine) {
            if (line.checkNumber == line.numbers.size())
                return true;
        }
        return false;
    }

    public boolean hasOneColumnMarked() {
        for (Line column : this.lstColumn) {
            if (column.checkNumber == column.numbers.size())
                return true;
        }
        return false;
    }

    public List<Line> getLstLine() {
        return new ArrayList<>(lstLine);
    }

    public void computeColumn() {
        //create column like line
        this.lstColumn = new ArrayList<>();

        for (int i = 0; i < this.lstLine.get(0).getNumbers().size(); i++) {
            List<Integer> numbers = new ArrayList<>();
            for (Line line : this.lstLine) {
                //recup int de chaque ligne + ajouté et faire check de chaque colone
                numbers.add(line.getNumbers().get(i));
            }
            Line column = new Line(numbers);
            this.addColumn(column);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Planche)) return false;
        Planche planche = (Planche) o;
        return planche.getLstLine().containsAll(this.getLstLine());
    }

    @Override
    public int hashCode() {
        return Objects.hash(lstLine, lstColumn);
    }

    public int computeScore(List<Integer> numbersMarked) {
        int result = 0;
        List<Integer> unmarkedNumbers = new ArrayList<>();
        for (Line line : this.lstLine) {
            unmarkedNumbers.addAll(line.uncheckNumber(numbersMarked));
        }
        result = unmarkedNumbers.stream().mapToInt(Integer::intValue).sum();
        result = result * numbersMarked.get(numbersMarked.size()-1);

        return result;
    }
}
