package lv.javaguru.junit.workshop.lesson_1_home_work;

import lv.javaguru.junit.workshop.lesson_1_home_work.rules.FBRules;

import java.util.Arrays;

public class FizzBuzzImpl implements FizzBuzz {
    private FBRules[] fbRules;

    public FizzBuzzImpl(FBRules[] fbRules) {
        this.fbRules = fbRules;
    }

    @Override
    public String calculate(int number) {
        return Arrays.stream(fbRules)
                .filter(r -> r.check(number))
                .findFirst()
                .orElseThrow(()-> new RuntimeException("No rule detected"))
                .getResult(number);
    }

}
