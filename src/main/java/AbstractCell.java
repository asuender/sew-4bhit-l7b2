public abstract class AbstractCell implements Observer, CellInterface {
    protected final Table table;

    protected double value;

    public AbstractCell(Table table) {
        this.table = table;
    }

    public AbstractCell(double value, Table table) {
        this.table = table;
        this.value = value;
    }
}
