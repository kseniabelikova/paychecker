package net.paychecker.taxes.config;

/**
 * @author Ksenia Belikova
 * @version 2/12/17.
 */
public class TaxBracket {
    private double taxRate;
    private double fixedTax;

    private  double lowerBound;
    private  double upperBound;

    public TaxBracket(double taxRate, double fixedTax, double lowerBound, double upperBound) {
        this.taxRate = taxRate;
        this.fixedTax = fixedTax;
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
    }

    public double getTaxRate() {
        return taxRate;
    }

    public double getFixedTax() {
        return fixedTax;
    }

    public double getLowerBound() {
        return lowerBound;
    }

    public double getUpperBound() {
        return upperBound;
    }
}
