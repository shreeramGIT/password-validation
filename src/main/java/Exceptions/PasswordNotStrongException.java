package Exceptions;

public class PasswordNotStrongException extends Exception {
    public PasswordNotStrongException() {
    }

    public PasswordNotStrongException(String message) {
        super(message);
    }

    public PasswordNotStrongException(String message, Throwable cause) {
        super(message, cause);
    }

    public PasswordNotStrongException(Throwable cause) {
        super(cause);
    }

    public PasswordNotStrongException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
