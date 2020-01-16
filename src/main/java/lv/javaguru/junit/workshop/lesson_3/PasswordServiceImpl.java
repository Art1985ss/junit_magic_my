package lv.javaguru.junit.workshop.lesson_3;

import lv.javaguru.junit.workshop.lesson_3.validation.PasswordValidation;

import java.util.ArrayList;
import java.util.List;

public class PasswordServiceImpl implements PasswordService {
    private List<PasswordValidation> validationRules;

    public PasswordServiceImpl(List<PasswordValidation> validationRules) {
        this.validationRules = validationRules;
    }

    @Override
    public String checkPassword(String newPassword) {
        validationRules.forEach(v -> v.validate(newPassword));
        return newPassword;
    }
}
