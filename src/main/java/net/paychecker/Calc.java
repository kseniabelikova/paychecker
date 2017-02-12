package net.paychecker;

import net.paychecker.taxes.FederalTax;
import net.paychecker.taxes.MedicareTax;
import net.paychecker.taxes.SocialSecurityTax;

/**
 * @author Ksenia Belikova
 * @version 2/4/17.
 */
public class Calc {

    public TaxResult[] calcTaxes(InputInfo inputInfo) {

        MedicareTax medicareTax = new MedicareTax();
        TaxResult medicareTaxResult = medicareTax.calc(inputInfo);

        SocialSecurityTax socialSecurityTax = new SocialSecurityTax();
        TaxResult socialTaxResult = socialSecurityTax.calc(inputInfo);

        FederalTax federalTax = new FederalTax();
        TaxResult federalTaxResult = federalTax.calc(inputInfo);

        TaxResult[] allTaxes = new TaxResult[]{medicareTaxResult, socialTaxResult,federalTaxResult};

        return allTaxes;
    }


}
