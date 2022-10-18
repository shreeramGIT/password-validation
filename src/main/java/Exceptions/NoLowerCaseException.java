package Exceptions;

public class NoLowerCaseException extends Exception{
    public NoLowerCaseException() {
    }

    public NoLowerCaseException(String message) {
        super(message);
    }

    public NoLowerCaseException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoLowerCaseException(Throwable cause) {
        super(cause);
    }

    public NoLowerCaseException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
