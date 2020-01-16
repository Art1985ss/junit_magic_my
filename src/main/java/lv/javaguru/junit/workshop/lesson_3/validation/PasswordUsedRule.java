package lv.javaguru.junit.workshop.lesson_3.validation;

public class PasswordUsedRule implements PasswordValidation {
    private UserRepository userRepository;

    @Override
    public void validate(String password) throws PasswordException {
        if (userRepository.usedLast3Times(password)){
            throw new PasswordException("New password should be different from last 3 used.");
        }
    }
}
