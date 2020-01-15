package lv.javaguru.junit.workshop.lesson_1_home_work.rules;

public class FizzRule implements FBRules {
    private static final int DIVIDER = 3;
    private static final String NAME = "Fizz";

    @Override
    public boolean check(int num) {
        return num % DIVIDER == 0;
    }

    @Override
    public String getResult(int num) {
        return NAME;
    }
}
