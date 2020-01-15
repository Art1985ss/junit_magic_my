package lv.javaguru.junit.workshop.lesson_1_home_work.rules;

public class FizzBuzzRule implements FBRules {
    private static final int DIVIDER = 15;
    private static final String NAME = "FizzBuzz";

    @Override
    public boolean check(int num) {
        return num % DIVIDER == 0;
    }

    @Override
    public String getResult(int num) {
        return NAME;
    }
}
