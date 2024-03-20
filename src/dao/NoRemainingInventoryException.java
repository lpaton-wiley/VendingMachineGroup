package dao;

public class NoRemainingInventoryException extends Exception {

    public NoRemainingInventoryException(String message) {
        super(message);
    }

    public NoRemainingInventoryException(String message, Throwable cause) {
        super(message, cause);
    }


}
