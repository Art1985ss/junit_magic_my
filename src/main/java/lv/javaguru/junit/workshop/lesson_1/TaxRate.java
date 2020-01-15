package lv.javaguru.junit.workshop.lesson_1;

public class TaxRate {
    private double border;
    private double lowerRate;
    private double upperRate;

    public TaxRate(double border, double lowerRate, double upperRate) {
        this.border = border;
        this.lowerRate = lowerRate;
        this.upperRate = upperRate;
    }

    public TaxRate() {

    }

    public double getBorder() {
        return border;
    }

    public void setBorder(double border) {
        this.border = border;
    }

    public double getLowerRate() {
        return lowerRate;
    }

    public void setLowerRate(double lowerRate) {
        this.lowerRate = lowerRate;
    }

    public double getUpperRate() {
        return upperRate;
    }

    public void setUpperRate(double upperRate) {
        this.upperRate = upperRate;
    }
}
