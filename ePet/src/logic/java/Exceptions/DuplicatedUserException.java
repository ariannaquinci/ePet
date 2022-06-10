package Exceptions;

public class DuplicatedUserException extends Exception {

    private static final String MESSAGE = "User already signed in, change email or log in.";

    public DuplicatedUserException() {
        super(MESSAGE);
    }
}
