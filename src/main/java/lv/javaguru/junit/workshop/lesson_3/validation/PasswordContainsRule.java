package lv.javaguru.junit.workshop.lesson_3.validation;

public class PasswordContainsRule implements PasswordValidation {
    @Override
    public void validate(String password) throws PasswordException {
        if (!containsChar(password)) {
            throw new PasswordException("Password must contain letters.");
        }
        if (!containsNumber(password)) {
            throw new PasswordException("Password must contain numbers.");
        }
    }

    private boolean containsChar(String s) {
        s = s.toUpperCase();
        String a = ".*[A-Z].*";
        return s.matches(a);
    }

    private boolean containsNumber(String s) {
        String n = ".*[0-9].*";
        return s.matches(n);
    }
}
