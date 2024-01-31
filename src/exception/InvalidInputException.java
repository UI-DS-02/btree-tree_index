package exception;

public class InvalidInputException extends RuntimeException {
    public InvalidInputException(String massage) {
        super(massage);
    }

    public InvalidInputException() {
        super("The input value is not valid");
    }
}
