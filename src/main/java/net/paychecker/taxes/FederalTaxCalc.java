package net.paychecker.taxes;

import net.paychecker.IncomeInfo;
import net.paychecker.PayPeriod;
import net.paychecker.TaxCalcResult;
import net.paychecker.taxes.config.FederalTaxConfig;
import net.paychecker.taxes.config.TaxBracket;

/**
 * @author Ksenia Belikova
 * @version 2/11/17.
 */
public class FederalTaxCalc implements TaxCalc {
    @Override
    public TaxCalcResult calc(IncomeInfo incomeInfo) {
        double salary = incomeInfo.getSalary();
        int allowance = incomeInfo.getAllowance();

        PayPeriod payPeriod = incomeInfo.getPayPeriod();
        double allowanceAmount = FederalTaxConfig.getAllowances().get(payPeriod);
        double taxable = salary - (allowance * allowanceAmount);

        double tax = 0;
        TaxBracket[] taxBrackets = FederalTaxConfig.getAllBrackets().get(payPeriod);
        for (TaxBracket t : taxBrackets) {
            if (taxable >= t.getLowerBound() && taxable <= t.getUpperBound()) {
                tax = t.getFixedTax() + t.getTaxRate() * (taxable - t.getLowerBound());
            }

        }
        return new TaxCalcResult(this, tax);
    }


    @Override
    public String getTaxName() {
        return "Federal";
    }
}
