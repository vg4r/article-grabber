package net.sf.vgrs.gamesys.domain.exceptions;

public class DuplicateElementException extends DBException {

    public DuplicateElementException() {
    }

    public DuplicateElementException(String message) {
        super(message);
    }

    public DuplicateElementException(String message, Throwable cause) {
        super(message, cause);
    }

    public DuplicateElementException(Throwable cause) {
        super(cause);
    }

    public DuplicateElementException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
