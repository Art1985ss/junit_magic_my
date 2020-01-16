package lv.javaguru.junit.workshop.lesson_3;

import lv.javaguru.junit.workshop.lesson_3.validation.*;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class PasswordServiceImplTest {
    @Mock
    public PasswordRepository passwordRepository;

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
    public void passwordTooShortFail() {
        newPassword = "V1";
        expectedException.expect(PasswordException.class);
        expectedException.expectMessage("Password length must be at least 5 symbols.");
        victim.checkPassword(newPassword);
    }

    @Test
    public void shouldContainCharFail() {
        newPassword = "123456";
        expectedException.expect(PasswordException.class);
        expectedException.expectMessage("Password must contain letters.");
        victim.checkPassword(newPassword);
    }

    @Test
    public void shouldContainNumberFail() {
        newPassword = "abcdef";
        expectedException.expect(PasswordException.class);
        expectedException.expectMessage("Password must contain numbers.");
        victim.checkPassword(newPassword);
    }

    @Test
    public void passwordUsedLast3TimesFail() {
        newPassword = "Vasja1";
        expectedException.expect(PasswordException.class);
        expectedException.expectMessage("New password should be different from last 3 used.");
        when(passwordRepository.get3LastPasswords()).thenReturn(createOldPasswords());
        victim.checkPassword(newPassword);
        verify(passwordRepository).get3LastPasswords();
    }

    @Test
    public void shouldAcceptPasswordSuccess() {
        newPassword = "Vasja2";
        when(passwordRepository.get3LastPasswords()).thenReturn(createOldPasswords());
        String createdPassword = victim.checkPassword(newPassword);
        assertEquals(newPassword, createdPassword);
    }

    private List<String> createOldPasswords() {
        return Arrays.asList("Vasja1", "Kurva1", "Abcdrkg1");
    }
}