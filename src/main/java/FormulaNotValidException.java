public class FormulaNotValidException extends RuntimeException {
    public FormulaNotValidException() {
        super("Formula is not valid");
    }

    public FormulaNotValidException(String message) {
        super(message);
    }
}
