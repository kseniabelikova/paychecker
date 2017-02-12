package net.paychecker.taxes;

import net.paychecker.InputInfo;
import net.paychecker.TaxResult;

/**
 * @author Ksenia Belikova
 * @version 2/11/17.
 */
public class SocialSecurityTax implements Tax {

    @Override
    public TaxResult calc(InputInfo inputInfo) {
        double taxable;
        double tax;
        double taxRate = 0.062;
        double maxSalary = 118500;

        taxable = (Math.min(inputInfo.getSalary(), maxSalary));
        tax = taxable * taxRate;
        return new TaxResult(this, tax);
    }

    @Override
    public String getName() {
        return "Social Security";
    }
}
