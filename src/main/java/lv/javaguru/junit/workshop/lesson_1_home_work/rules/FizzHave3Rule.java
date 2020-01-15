package lv.javaguru.junit.workshop.lesson_1_home_work.rules;

public class FizzHave3Rule implements FBRules {
    private static final char HAVE_IN_STRING = '3';
    private static final String NAME = "Fizz";

    @Override
    public boolean check(int num) {
        return (num + "").indexOf(HAVE_IN_STRING) >= 0;
    }

    @Override
    public String getResult(int num) {
        return NAME;
    }
}
