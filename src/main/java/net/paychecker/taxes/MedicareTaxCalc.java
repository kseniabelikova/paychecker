package net.paychecker.taxes;

import net.paychecker.IncomeInfo;
import net.paychecker.TaxCalcResult;

/**
 * @author Ksenia Belikova
 * @version 2/11/17.
 */
public class MedicareTaxCalc implements TaxCalc {

    public TaxCalcResult calc(IncomeInfo incomeInfo) {
        double salary = incomeInfo.getSalary();
        double taxAmount = salary * 0.0145;
        if (salary > 200000) {
            taxAmount += (200000 - salary) * 0.009;
        }
        return new TaxCalcResult(this, taxAmount);
    }

    @Override
    public String getTaxName() {
        return "Medicare";
    }
}
