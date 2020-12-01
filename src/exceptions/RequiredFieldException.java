package exceptions;

public class RequiredFieldException extends Exception {

    public RequiredFieldException(String msg) {
        super(msg);
    }
}
