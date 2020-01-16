package lv.javaguru.junit.workshop.lesson_3.validation;

import java.util.List;

public interface PasswordRepository {
    List<String> get3LastPasswords();
}
