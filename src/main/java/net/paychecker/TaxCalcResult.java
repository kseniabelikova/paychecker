package net.paychecker;

import net.paychecker.taxes.TaxCalc;

/**
 * @author Ksenia Belikova
 * @version 2/11/17.
 */
public class TaxCalcResult {
    private TaxCalc tax;
    private double taxAmount;

    public TaxCalcResult(TaxCalc tax, double taxAmount) {
        this.tax = tax;
        this.taxAmount = taxAmount;
    }

    public TaxCalc getTax() {
        return tax;
    }

    public double getTaxAmount() {
        return taxAmount;
    }
}
