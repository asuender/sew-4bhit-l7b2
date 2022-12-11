import java.util.*;

public class Row {
    final int numCols;
    final List<Double> cells;

    public Row(int numCols) {
        this.numCols = numCols;
        this.cells = new LinkedList<Double>();

        for (int i = 0; i < numCols; i++) {
            cells.add(0.0);
        }
    }

    public void setCell(int col, double value) {
        cells.set(col, value);
    }

    public double getCell(int col) {
        return cells.get(col);
    }

    public int getNumCols() {
        return numCols;
    }
}
