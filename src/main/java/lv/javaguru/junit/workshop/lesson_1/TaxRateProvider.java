package lv.javaguru.junit.workshop.lesson_1;

public interface TaxRateProvider {
    TaxRate getTaxRate(int year) throws RateNotFoundException;
}
