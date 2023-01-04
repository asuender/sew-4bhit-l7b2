/**
 * This exception is thrown when a formula is not valid.
 * @author asuender
 * @version 0.2
 */
public class FormulaNotValidException extends RuntimeException {
    public FormulaNotValidException() {
        super("Formula is not valid");
    }

    public FormulaNotValidException(String message) {
        super(message);
    }
}
