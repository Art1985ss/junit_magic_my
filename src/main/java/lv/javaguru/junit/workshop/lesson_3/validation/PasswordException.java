package lv.javaguru.junit.workshop.lesson_3.validation;

public class PasswordException extends RuntimeException {
    public PasswordException(String message) {
        super(message);
    }
}
