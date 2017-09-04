package net.paychecker.taxes;

import net.paychecker.IncomeInfo;
import net.paychecker.TaxCalcResult;

/**
 * @author Ksenia Belikova
 * @version 2/11/17.
 */
public interface TaxCalc {
    TaxCalcResult calc(IncomeInfo incomeInfo);
    String getTaxName();
}
