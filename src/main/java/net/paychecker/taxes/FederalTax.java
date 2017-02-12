package net.paychecker.taxes;

import net.paychecker.*;
import net.paychecker.taxes.config.FederalTaxBracketHelper;
import net.paychecker.taxes.config.FederalTaxConfig;

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

        FederalTaxBracketHelper taxBracket = FederalTaxBracketHelper.findBracket(taxable, payPeriod);
        double tax = taxBracket.getFixedTax() + taxBracket.getTaxRate() * (taxable - taxBracket.getStartBracketAmount());
        return new TaxResult(this, tax);
    }


    @Override
    public String getName() {
        return "Federal";
    }
}
