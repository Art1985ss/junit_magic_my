package lv.javaguru.junit.workshop.lesson_3.validation;

public class PasswordLengthRule implements PasswordValidation {
    @Override
    public void validate(String password) throws PasswordException {
        if (password.length() < 5){
            throw new PasswordException("Password length must be at least 5 symbols.");
        }
    }
}
