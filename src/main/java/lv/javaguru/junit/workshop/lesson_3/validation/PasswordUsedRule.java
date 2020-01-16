package lv.javaguru.junit.workshop.lesson_3.validation;

import java.util.List;

public class PasswordUsedRule implements PasswordValidation {
    private PasswordRepository passwordRepository;

    @Override
    public void validate(String password) throws PasswordException {
        if (usedLast3Times(password)) {
            throw new PasswordException("New password should be different from last 3 used.");
        }
    }

    private boolean usedLast3Times(String password) {
        List<String> oldPasswords = passwordRepository.get3LastPasswords();
        return oldPasswords.stream().anyMatch(p -> p.equals(password));
    }
}
