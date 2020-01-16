package lv.javaguru.junit.workshop.lesson_3;

import lv.javaguru.junit.workshop.lesson_3.validation.*;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PasswordServiceImplTest {
    @Mock
    public UserRepository userRepository;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @InjectMocks
    public PasswordUsedRule passwordUsedRule = new PasswordUsedRule();
    public PasswordLengthRule passwordLengthRule = new PasswordLengthRule();
    public PasswordContainsRule passwordContainsRule = new PasswordContainsRule();
    List<PasswordValidation> validations = Arrays.asList(passwordLengthRule, passwordContainsRule, passwordUsedRule);
    private PasswordServiceImpl victim = new PasswordServiceImpl(validations);

    private String newPassword = "";


    @Test
    public void passwordTooShort() {
        newPassword = "V1";
        expectedException.expect(PasswordException.class);
        expectedException.expectMessage("Password length must be at least 5 symbols.");
        victim.createPassword(newPassword);
    }

    @Test
    public void shouldContainChar() {
        newPassword = "123456";
        expectedException.expect(PasswordException.class);
        expectedException.expectMessage("Password must contain letters.");
        victim.createPassword(newPassword);
    }

    @Test
    public void shouldContainNumber() {
        newPassword = "abcdef";
        expectedException.expect(PasswordException.class);
        expectedException.expectMessage("Password must contain numbers.");
        victim.createPassword(newPassword);
    }

    @Test
    public void passwordUsedLast3Times() {
        newPassword = "Vasja1";
        expectedException.expect(PasswordException.class);
        expectedException.expectMessage("New password should be different from last 3 used.");
        when(userRepository.usedLast3Times(newPassword)).thenReturn(true);
        victim.createPassword(newPassword);
    }

    @Test
    public void shouldCreatePassword(){
        newPassword = "Vasja1";
        when(userRepository.usedLast3Times(newPassword)).thenReturn(false);
        String createdPassword = victim.createPassword(newPassword);
        assertEquals(newPassword, createdPassword);
    }
}