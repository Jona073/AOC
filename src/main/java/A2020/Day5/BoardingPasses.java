package A2020.Day5;

public class BoardingPasses {
    private final int MAX_ROW = 127;
    private final int MAX_COLUMN = 7;
    private String rowPartition;
    private String columnPartition;


    public BoardingPasses(String binarySpace) {
        this.rowPartition = binarySpace.substring(0,6);
        this.columnPartition = binarySpace.substring(7,10);
    }

    public String getRowPartition() {
        return rowPartition;
    }

    public String getColumnPartition() {
        return columnPartition;
    }

    public int getColumn() {
        int maxColumn = MAX_COLUMN;
        int minColumn = 0;
        for (char half: this.getColumnPartition().toCharArray()) {
            switch (half) {
                case 'R':
                    minColumn += Math.round((maxColumn - minColumn) / 2f);
                    break;
                case 'L':
                    maxColumn -= Math.round((maxColumn - minColumn) / 2f);
                    break;
                default:
                    throw new IllegalArgumentException("Impossible la colonne : " + this.getColumnPartition());
            }
        }
        return minColumn;
    }

    public int getRow() {
        int maxRow = MAX_ROW;
        int minRow = 0;
        for (char half: this.getRowPartition().toCharArray()) {
            switch (half) {
                case 'B':
                    minRow += Math.round((maxRow - minRow) / 2f);
                    break;
                case 'F':
                    maxRow -= Math.round((maxRow - minRow) / 2f);
                    break;
                default:
                    throw new IllegalArgumentException("Impossible la ligne : " + this.getColumnPartition());
            }
        }
        return minRow;
    }

    public int getID() {
        return this.getRow() * 8 + this.getColumn();
    }



}
