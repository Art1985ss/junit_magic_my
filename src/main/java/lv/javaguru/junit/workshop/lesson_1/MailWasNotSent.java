package lv.javaguru.junit.workshop.lesson_1;

public class MailWasNotSent extends RuntimeException {
    private double income;
    public MailWasNotSent(double income) {
        this.income = income;
    }
}
