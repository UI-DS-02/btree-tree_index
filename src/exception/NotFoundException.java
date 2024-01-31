package exception;

public class NotFoundException extends RuntimeException {
    public NotFoundException() {
        super("The requested item was not found");
    }

    public NotFoundException(String message) {
        super(message);
    }
}
