package net.paychecker.taxes;

import net.paychecker.InputInfo;
import net.paychecker.TaxResult;

/**
 * @author Ksenia Belikova
 * @version 2/11/17.
 */
public class MedicareTax implements Tax {

    public TaxResult calc(InputInfo inputInfo) {
        double salary = inputInfo.getSalary();
        double taxAmount = salary * 0.0145;
        if (salary > 200000) {
            taxAmount += (200000 - salary) * 0.009;
        }
        return new TaxResult(this, taxAmount);
    }

    @Override
    public String getName() {
        return "Medicare";
    }
}
