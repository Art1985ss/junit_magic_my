package lv.javaguru.junit.workshop.lesson_1_home_work;

import lv.javaguru.junit.workshop.lesson_1_home_work.rules.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FizzBuzzImplTest {
    private static final String FIZZ = "Fizz";
    private static final String BUZZ = "Buzz";
    private static final String FIZZ_BUZZ = "FizzBuzz";

    FBRules[] fbRules = {new FizzBuzzRule(), new FizzRule(), new FizzHave3Rule(), new BuzzRule(), new BuzzHave5Rule(), new NoFizzNoBuzzRule()};
    private FizzBuzzImpl victim = new FizzBuzzImpl(fbRules);

    @Test
    public void shouldReturnFizzWhen3() {
        calculate(3, FIZZ);
        calculate(33, FIZZ);
    }

    @Test
    public void shouldReturnBuzzWhen5() {
        calculate(5, BUZZ);
        calculate(25, BUZZ);
    }

    @Test
    public void shouldReturnFizzBuzzWhen15() {
        calculate(15, FIZZ_BUZZ);
        calculate(30, FIZZ_BUZZ);
    }

    @Test
    public void shouldReturnInputValue() {
        calculate(16, "16");
        calculate(22, "22");
    }

    @Test
    public void shouldReturnFizzIfContains3() {
        calculate(23, FIZZ);
        calculate(73, FIZZ);
    }

    @Test
    public void shouldReturnBuzzIfContains5() {
        calculate(52, BUZZ);
        calculate(56, BUZZ);
    }

    private void calculate(int inputValue, String expectedOutput) {
        assertEquals(expectedOutput, victim.calculate(inputValue));
    }
}