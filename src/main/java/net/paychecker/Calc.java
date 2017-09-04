package net.paychecker;

import net.paychecker.taxes.FederalTaxCalc;
import net.paychecker.taxes.MedicareTaxCalc;
import net.paychecker.taxes.SocialSecurityTaxCalc;

/**
 * @author Ksenia Belikova
 * @version 2/4/17.
 */
public class Calc {

    public TaxCalcResult[] calcTaxes(IncomeInfo incomeInfo) {

        MedicareTaxCalc medicareTaxCalc = new MedicareTaxCalc();
        TaxCalcResult medicareTaxResult = medicareTaxCalc.calc(incomeInfo);

        SocialSecurityTaxCalc socialSecurityTaxCalc = new SocialSecurityTaxCalc();
        TaxCalcResult socialTaxResult = socialSecurityTaxCalc.calc(incomeInfo);

        FederalTaxCalc federalTaxCalc = new FederalTaxCalc();
        TaxCalcResult federalTaxResult = federalTaxCalc.calc(incomeInfo);

        TaxCalcResult[] allTaxes = new TaxCalcResult[]{medicareTaxResult, socialTaxResult,federalTaxResult};

        return allTaxes;
    }


}


