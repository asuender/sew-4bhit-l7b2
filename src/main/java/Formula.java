import java.sql.SQLOutput;

public class Formula implements Observer {
    private String formula;

    private Cell connectedCell;
    private Cell cell1;
    private Cell cell2;

    public Formula(String formula, Cell connectedCell, Cell cell1, Cell cell2) {
        this.formula = formula;
        this.connectedCell = connectedCell;
        this.cell1 = cell1;
        this.cell2 = cell2;

        this.cell1.attach(this);
        this.cell2.attach(this);

        this.update();
    }

    public void setFormula(String formula) {
        if (formula == null || formula.isEmpty()) {
            throw new FormulaNotValidException("Formula is null or empty");
        }

        if (formula.charAt(0) != '=') {
            throw new FormulaNotValidException("Formula must start with '='");
        }

        this.formula = formula.trim();
    }

    @Override
    public void update() {
        String f = this.formula.substring(1);

        String operator = f.replaceAll("[A-Z0-9]", "").trim();

        double value1 = this.cell1.getValue();
        double value2 = this.cell2.getValue();

        switch (operator) {
            case "+":
                this.connectedCell.setValue(value1 + value2);
                break;
            case "-":
                this.connectedCell.setValue(value1 - value2);
                break;
            case "*":
                this.connectedCell.setValue(value1 * value2);
                break;
            case "/":
                this.connectedCell.setValue(value1 / value2);
                break;
        }
    }
}
