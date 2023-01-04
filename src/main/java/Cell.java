public class Cell extends Subject {
    private double value;
    private Formula formula;

    public Cell(double value) {
        this.value = value;
    }

    public Cell(Formula formula) {
        super();
        this.formula = formula;
    }

    public Cell(String formulaText, Cell cell1, Cell cell2) {
        super();
        this.formula = new Formula(formulaText, this, cell1, cell2);
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;

        super.notifyObservers();
    }

    public Formula getFormula() {
        return formula;
    }

    public void setFormula(Formula formula) {
        this.formula = formula;
    }

    @Override
    public String toString() {
        return String.format("%.2f", this.value);
    }
}