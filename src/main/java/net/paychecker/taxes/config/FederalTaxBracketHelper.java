package net.paychecker.taxes.config;

import net.paychecker.PayPeriod;

/**
 * @author Ksenia Belikova
 * @version 2/5/17.
 */
public class FederalTaxBracketHelper {

    private double taxRate;
    private double fixedTax;
    private double startBracketAmount;

    private  double min;
    private  double max;

    public FederalTaxBracketHelper(double fixedTax, double rate, double taxable) {
        this.taxRate = rate;
        this.fixedTax = fixedTax;
        this.startBracketAmount = taxable;
    }

    public FederalTaxBracketHelper(double min, double max, double rate, double fixedTax){
        this.max = max;
        this.min = min;
        this.fixedTax = fixedTax;
        this.taxRate = rate;
    }

    public double getTaxRate() {
        return taxRate;
    }

    public double getFixedTax() {
        return fixedTax;
    }

    public double getStartBracketAmount() {
        return startBracketAmount;
    }

    public static FederalTaxBracketHelper findBracket(double taxable, PayPeriod payPeriod) {
        double fixedTax = 0;
        int n = 0;

        BracketConfig[] brackets = (BracketConfig[]) FederalTaxConfig.getBrackets().get(payPeriod);
        for (int i = 0; i < brackets.length; i++) {
            if (brackets[i].getMaxTaxable() >= taxable) {
                n = i;
                break;
            }
            if (i > 0) {
                double bracketAmount = brackets[i].getMaxTaxable() - brackets[i - 1].getMaxTaxable();
                double bracketTaxRate = brackets[i].getTaxRate();
                fixedTax += bracketAmount * bracketTaxRate;
            }
        }
        FederalTaxBracketHelper taxBracketAnnually = new FederalTaxBracketHelper(fixedTax,
                brackets[n].getTaxRate(),
                n > 0 ? brackets[n - 1].getMaxTaxable() : 0);
        FederalTaxBracketHelper result = taxBracketAnnually;
        return result;
    }

}
