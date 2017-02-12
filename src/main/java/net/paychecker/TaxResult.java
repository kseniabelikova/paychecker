package net.paychecker;

import net.paychecker.taxes.Tax;

/**
 * @author Ksenia Belikova
 * @version 2/11/17.
 */
public class TaxResult {
    private Tax tax;
    private double taxAmount;

    public TaxResult(Tax tax, double taxAmount) {
        this.tax = tax;
        this.taxAmount = taxAmount;
    }

    public Tax getTax() {
        return tax;
    }

    public double getTaxAmount() {
        return taxAmount;
    }
}
