package lv.javaguru.junit.workshop.lesson_3;

import lv.javaguru.junit.workshop.lesson_3.validation.PasswordException;

public interface PasswordService {
    String checkPassword(String newPassword) throws PasswordException;
}
