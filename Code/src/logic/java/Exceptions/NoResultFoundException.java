package Exceptions;

public class NoResultFoundException extends Throwable {

    private static final String MESSAGE = "No results found.";

    public NoResultFoundException() {
        super(MESSAGE);
    }

    public NoResultFoundException(String string) {
        super(string);  //chiama costruttore super(string) di Throwable
    }

}
