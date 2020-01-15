package lv.javaguru.junit.workshop.lesson_1;

public class TaxCalculatorImpl implements TaxCalculator {
    private TaxRateProvider taxRateProvider;
    private MailSender mailSender;

    public TaxCalculatorImpl(TaxRateProvider taxRateProvider,
                             MailSender mailSender) {
        this.taxRateProvider = taxRateProvider;
        this.mailSender = mailSender;
    }

    @Override
    public TaxCalculatorResponse calculateTax(double income, int year) {
        if (income > 100000){
            try {
                mailSender.sendMail(income);
            }catch (MailWasNotSent e){
                //
            }
        }
        TaxRate taxRate;
        double tax;
        try{
            taxRate = taxRateProvider.getTaxRate(year);
        }catch (RateNotFoundException e){
            return new TaxCalculatorResponse("Year not valid!");
        }
        if (income <= taxRate.getBorder()) {
            tax = income * taxRate.getLowerRate();
            return new TaxCalculatorResponse(tax);
        }
        double firstTax = taxRate.getBorder() * taxRate.getLowerRate();
        double secondTax = (income - taxRate.getBorder()) * taxRate.getUpperRate();
        tax = firstTax + secondTax;
        return new TaxCalculatorResponse(tax);
    }
}
