import java.sql.SQLOutput;

public class Formula extends AbstractCell {
    private String formula;


    public Formula(String formula, Table table) {
        super(table);
        setValue(formula);
    }

    public void setValue(String formula) {
        if (formula == null || formula.isEmpty()) {
            throw new FormulaNotValidException("Formula is null or empty");
        }

        if (formula.charAt(0) != '=') {
            throw new FormulaNotValidException("Formula must start with '='");
        }

        this.formula = formula.trim();
    }

    @Override
    public double getValue() {
        return this.value;
    }

    @Override
    public void update() {
        String f = this.formula.substring(1);

        String[] parts = f.split("[+\\-*/]");
        String operator = f.replaceAll("[A-Z0-9]", "").trim();

        double value1 = this.table.getCell(parts[0]).getValue();
        double value2 = this.table.getCell(parts[1]).getValue();

        switch (operator) {
            case "+":
                this.value = value1 + value2;
                break;
            case "-":
                this.value = value1 - value2;
                break;
            case "*":
                this.value = value1 * value2;
                break;
            case "/":
                this.value = value1 / value2;
                break;
        }
    }

    @Override
    public String print() {
        return String.valueOf(this.value);
    }

    @Override
    public String printRaw() {
        return this.formula;
    }
}
