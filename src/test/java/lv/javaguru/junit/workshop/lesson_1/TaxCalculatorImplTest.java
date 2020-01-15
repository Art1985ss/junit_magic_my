package lv.javaguru.junit.workshop.lesson_1;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;

public class TaxCalculatorImplTest {
    private static final double delta = 0.00001;

    private TaxRateProvider taxRateProvider;
    private MailSender mailSender;
    private TaxCalculator calculator;

    @Before
    public void setup() {
        taxRateProvider = Mockito.mock(TaxRateProvider.class);
        mailSender = Mockito.mock(MailSender.class);
        calculator = new TaxCalculatorImpl(taxRateProvider, mailSender);
    }

    @Test
    public void income20000year2000() {
        Mockito.when(taxRateProvider.getTaxRate(2000))
                .thenReturn(createTaxRate(20000, 0.25, 0.40));
        checkResult(20000.0, 2000, new TaxCalculatorResponse(5000.0));
        Mockito.verify(taxRateProvider).getTaxRate(2000);
    }

    @Test
    public void income20000year2001() {
        Mockito.when(taxRateProvider.getTaxRate(2001))
                .thenReturn(createTaxRate(10000.0, 0.5, 0.9));
        checkResult(20000.0, 2001, new TaxCalculatorResponse(14000.0));
        Mockito.verify(taxRateProvider).getTaxRate(2001);
    }

    private void checkResult(double income, int inputYear, TaxCalculatorResponse expectedTax) {
        assertEquals(expectedTax.getTax(), calculator.calculateTax(income, inputYear).getTax(), delta);
    }

    @Test(expected = RuntimeException.class)
    public void throwException() {
        Mockito.when(taxRateProvider.getTaxRate(2000))
                .thenThrow(new RuntimeException());
        checkResult(20000, 2000, new TaxCalculatorResponse(5000.0));
    }

    @Test
    public void shouldSendMail() {
        Mockito.when(taxRateProvider.getTaxRate(2015))
                .thenReturn(createTaxRate(20000, 0.25, 0.40));
        assertEquals(57000.0, calculator.calculateTax(150000, 2015).getTax(), delta);
        Mockito.verify(mailSender).sendMail(150000);
    }

    @Test
    public void shouldFailSendMail() {
        Mockito.when(taxRateProvider.getTaxRate(2015))
                .thenReturn(createTaxRate(20000, 0.25, 0.40));
        assertEquals(57000.0, calculator.calculateTax(150000, 2015).getTax(), delta);
        Mockito.doThrow(new MailWasNotSent(150000))
                .when(mailSender).sendMail(150000);
    }

    private TaxRate createTaxRate(double border, double lowerRate, double upperRate) {
        TaxRate taxRate = new TaxRate();
        taxRate.setBorder(border);
        taxRate.setLowerRate(lowerRate);
        taxRate.setUpperRate(upperRate);
        return taxRate;
    }

}