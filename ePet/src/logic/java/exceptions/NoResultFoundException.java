package exceptions;

public class NoResultFoundException extends Exception {

    private static final String MESSAGE = "No results found.";

    public NoResultFoundException() {
        super(MESSAGE);
    }

    public NoResultFoundException(String string) {
        super(string);  //chiama costruttore super(string) di Throwable
    }

}
