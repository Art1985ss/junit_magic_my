package lv.javaguru.junit.workshop.lesson_1_home_work.rules;

public class NoFizzNoBuzzRule implements FBRules {
    private static final String NAME = "Number";

    @Override
    public boolean check(int num) {
        return true;
    }

    @Override
    public String getResult(int num) {
        return num + "";
    }
}
