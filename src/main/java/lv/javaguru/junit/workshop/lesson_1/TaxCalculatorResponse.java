package lv.javaguru.junit.workshop.lesson_1;

public class TaxCalculatorResponse {

    private boolean isOk;
    private Double tax;
    private String message;

    public TaxCalculatorResponse() {
    }

    public TaxCalculatorResponse(boolean isOk, double tax, String message) {
        this.isOk = isOk;
        this.tax = tax;
        this.message = message;
    }

    public TaxCalculatorResponse(Double tax) {
        isOk = true;
        this.tax = tax;
    }

    public TaxCalculatorResponse(String message) {
        isOk = false;
        this.message = message;
    }

    public boolean isOk() {
        return isOk;
    }

    public void setOk(boolean ok) {
        isOk = ok;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
