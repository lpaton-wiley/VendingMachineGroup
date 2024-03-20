package dao;

public class NotPaidFullException extends Exception{

    public NotPaidFullException(String message) {
        super(message);
    }

    public NotPaidFullException(String message, Throwable cause) {super(message, cause);}
}
