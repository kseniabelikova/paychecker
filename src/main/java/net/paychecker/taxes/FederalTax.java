package net.paychecker.taxes;

import net.paychecker.InputInfo;
import net.paychecker.PayPeriod;
import net.paychecker.TaxResult;
import net.paychecker.taxes.config.FederalTaxConfig;
import net.paychecker.taxes.config.TaxBracket;

/**
 * @author Ksenia Belikova
 * @version 2/11/17.
 */
public class FederalTax implements Tax {
    @Override
    public TaxResult calc(InputInfo inputInfo) {
        double salary = inputInfo.getSalary();
        int allowance = inputInfo.getAllowance();

        PayPeriod payPeriod = inputInfo.getPayPeriod();
        double allowanceAmount = FederalTaxConfig.getAllowances().get(payPeriod);
        double taxable = salary - (allowance * allowanceAmount);

        double tax = 0;
        TaxBracket[] taxBrackets = FederalTaxConfig.getAllBrackets().get(payPeriod);
        for (TaxBracket t : taxBrackets) {
            if (taxable >= t.getLowerBound() && taxable <= t.getUpperBound()) {
                tax = t.getFixedTax() + t.getTaxRate() * (taxable - t.getLowerBound());
            }

        }
        return new TaxResult(this, tax);
    }


    @Override
    public String getName() {
        return "Federal";
    }
}
