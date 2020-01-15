package lv.javaguru.junit.workshop.lesson_1;

public class TaxRateProviderStub implements TaxRateProvider {
    @Override
    public TaxRate getTaxRate(int year) {
        if (year == 2000) {
            TaxRate taxRate = new TaxRate();
            taxRate.setBorder(20000);
            taxRate.setLowerRate(0.25);
            taxRate.setUpperRate(0.40);
            return taxRate;
        }
        return null;
    }
}
