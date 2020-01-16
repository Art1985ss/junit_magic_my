package lv.javaguru.junit.workshop.lesson_3.validation;

public interface PasswordValidation {
    void validate(String password) throws PasswordException;
}
