public class Cell extends AbstractCell {
    public Cell(double value, Table table) {
        super(value, table);
    }

    @Override
    public double getValue() {
        return this.value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public void update() {

    }

    @Override
    public String print() {
        return String.valueOf(value);
    }

    @Override
    public String printRaw() {
        return this.print();
    }
}
