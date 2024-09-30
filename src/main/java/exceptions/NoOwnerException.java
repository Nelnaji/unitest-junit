package exceptions;

public class NoOwnerException extends  RuntimeException{

    public NoOwnerException(){
        super("Owner doesn't exist");
    }

    public NoOwnerException(String myErrorMessage) {
        super(myErrorMessage);
    }
}
