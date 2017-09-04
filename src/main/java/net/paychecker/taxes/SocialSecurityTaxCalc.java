package net.paychecker.taxes;

import net.paychecker.IncomeInfo;
import net.paychecker.TaxCalcResult;

/**
 * @author Ksenia Belikova
 * @version 2/11/17.
 */
public class SocialSecurityTaxCalc implements TaxCalc {

    @Override
    public TaxCalcResult calc(IncomeInfo incomeInfo) {
        double taxable;
        double tax;
        double taxRate = 0.062;
        double maxSalary = 118500;

        taxable = (Math.min(incomeInfo.getSalary(), maxSalary));
        tax = taxable * taxRate;
        return new TaxCalcResult(this, tax);
    }

    @Override
    public String getTaxName() {
        return "Social Security";
    }
}
