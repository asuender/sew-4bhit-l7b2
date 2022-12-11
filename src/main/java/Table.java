import java.util.*;

public class Table extends Subject {
    private final int numRows;
    private final int numCols;

    private Map<String, Map<Integer, AbstractCell>> cells;

    public Table(int numRows, int mumCols) {
        super();

        this.numRows = numRows;
        this.numCols = mumCols;
        this.cells = new HashMap<>();

        for (int i = 0; i < numCols; i++) {
            String key = String.valueOf((char) (i + 65));
            cells.put(key, new HashMap<>(numRows));
        }
    }

    public void setCell(String pos, AbstractCell cell) {
        if (pos.length() != 2) {
            throw new IllegalArgumentException("Position must be 2 characters long");
        }

        this.setCell(String.valueOf(pos.charAt(0)), Integer.parseInt(String.valueOf(pos.charAt(1))), cell);
    }

    public void setCell(String col, int row, AbstractCell cell) {
        AbstractCell _cell = this.cells.get(col).get(row);

        if (_cell != null) {
            this.detach(_cell);
        }

        this.attach(cell);

        this.cells.get(col).put(row, cell);

        this.notifyObservers();
    }

    public AbstractCell getCell(String pos) {
        if (pos.length() != 2) {
            throw new IllegalArgumentException("Position must be 2 characters long");
        }

        return this.cells.get(String.valueOf(pos.charAt(0))).get(Integer.parseInt(String.valueOf(pos.charAt(1))));
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (String col : cells.keySet()) {
            sb.append(String.format("\t%s\t", col));
        }

        sb.append("\n");

        for (int i = 1; i <= numRows; i++) {
            for (String col : cells.keySet()) {
                sb.append(String.format("\t%s\t", cells.get(col).get(i).print()));
            }
            sb.append("\n");
        }

        return sb.toString();
    }
}
