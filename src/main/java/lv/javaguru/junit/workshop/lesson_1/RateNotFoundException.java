package lv.javaguru.junit.workshop.lesson_1;

public class RateNotFoundException extends RuntimeException {
    private int year;

    public RateNotFoundException(int year) {
        this.year = year;
        throw new RuntimeException("No such year " + year);
    }
}
