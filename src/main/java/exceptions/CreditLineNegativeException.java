package exceptions;

public class CreditLineNegativeException extends RuntimeException{
    public CreditLineNegativeException() {
    }

    public CreditLineNegativeException(String message) {
        super(message);
    }
}
