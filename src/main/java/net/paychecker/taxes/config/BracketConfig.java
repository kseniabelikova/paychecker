package net.paychecker.taxes.config;

/**
 * @author Ksenia Belikova
 * @version 2/6/17.
 */
public class BracketConfig {
    private double maxTaxable;
    private double taxRate;

    public BracketConfig(double taxable, double rate) {
        this.maxTaxable = taxable;
        this.taxRate = rate;
    }


    public double getMaxTaxable() {
        return maxTaxable;
    }


    public double getTaxRate() {
        return taxRate;
    }
}
