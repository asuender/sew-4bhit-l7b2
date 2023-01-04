import java.util.*;

public class Table {
    private final int numRows;
    private final int numCols;

    private Map<String, Map<Integer, Cell>> cells;

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

    public void setCell(String pos, Cell cell) {
        if (pos.length() != 2) {
            throw new IllegalArgumentException("Position must be 2 characters long");
        }

        this.setCell(String.valueOf(pos.charAt(0)), Integer.parseInt(String.valueOf(pos.charAt(1))), cell);
    }

    public void setCell(String col, int row, Cell cell) {
        this.cells.get(col).put(row, cell);
    }

    public Cell getCell(String pos) {
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
                sb.append(String.format("\t%s\t", cells.get(col).get(i)));
            }
            sb.append("\n");
        }

        return sb.toString();
    }
}
