package exceptions;

public class NonPositiveNumberException extends RuntimeException{

    public NonPositiveNumberException(String errorMessage) {
        super(errorMessage);
    }
}
