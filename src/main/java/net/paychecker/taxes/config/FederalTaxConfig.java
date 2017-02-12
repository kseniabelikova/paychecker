package net.paychecker.taxes.config;

import net.paychecker.PayPeriod;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ksenia Belikova
 * @version 2/11/17.
 */
public class FederalTaxConfig {
    private static Map<PayPeriod, BracketConfig[]> bracketConfigsMap = new HashMap<>();
    private static Map<PayPeriod, Double> allowances = new HashMap<>();

    static {
        bracketConfigsMap.put(PayPeriod.WEEKLY, new BracketConfig[]{
                new BracketConfig(43, 0),
                new BracketConfig(222, 0.1),
                new BracketConfig(767, 0.15),
                new BracketConfig(1796, 0.25),
                new BracketConfig(3700, 0.28),
                new BracketConfig(7992, 0.33),
                new BracketConfig(8025, 0.35),
                new BracketConfig(Double.MAX_VALUE, 0.369)});

        bracketConfigsMap.put(PayPeriod.BIWEEKLY, new BracketConfig[]{
                new BracketConfig(87, 0),
                new BracketConfig(443, 0.1),
                new BracketConfig(1535, 0.15),
                new BracketConfig(3592, 0.25),
                new BracketConfig(7400, 0.28),
                new BracketConfig(15985, 0.33),
                new BracketConfig(16050, 0.35),
                new BracketConfig(Double.MAX_VALUE, 0.369)});

        bracketConfigsMap.put(PayPeriod.SEMIMONTHLY, new BracketConfig[]{
                new BracketConfig(94, 0),
                new BracketConfig(480, 0.1),
                new BracketConfig(1663, 0.15),
                new BracketConfig(3892, 0.25),
                new BracketConfig(8017, 0.28),
                new BracketConfig(17317, 0.33),
                new BracketConfig(17388, 0.35),
                new BracketConfig(Double.MAX_VALUE, 0.369)});

        bracketConfigsMap.put(PayPeriod.MONTHLY, new BracketConfig[]{
                new BracketConfig(188, 0),
                new BracketConfig(960, 0.1),
                new BracketConfig(3325, 0.15),
                new BracketConfig(7783, 0.25),
                new BracketConfig(16033, 0.28),
                new BracketConfig(34633, 0.33),
                new BracketConfig(34775, 0.35),
                new BracketConfig(Double.MAX_VALUE, 0.369)});

        bracketConfigsMap.put(PayPeriod.ANNUALLY, new BracketConfig[]{
                new BracketConfig(2250, 0),
                new BracketConfig(11525, 0.1),
                new BracketConfig(39900, 0.15),
                new BracketConfig(93400, 0.25),
                new BracketConfig(192400, 0.28),
                new BracketConfig(415600, 0.33),
                new BracketConfig(417300, 0.35),
                new BracketConfig(Double.MAX_VALUE, 0.369)});
    }

    static {
        allowances.put(PayPeriod.WEEKLY, 77.90);
        allowances.put(PayPeriod.BIWEEKLY, 155.80);
        allowances.put(PayPeriod.SEMIMONTHLY, 168.80);
        allowances.put(PayPeriod.MONTHLY, 337.50);
        allowances.put(PayPeriod.ANNUALLY, 4050.0);
    }

    public static FederalTaxBracketHelper findBracket(double taxable, PayPeriod payPeriod) {
        double fixedTax = 0;
        int n = 0;

        BracketConfig[] brackets = (BracketConfig[]) FederalTaxConfig.getBracketConfigsMap().get(payPeriod);
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

    static TaxBracket[] allBrackets;

    static {
        allBrackets = new TaxBracket[bracketConfigsMap.get(PayPeriod.WEEKLY).length];
        BracketConfig[] bracketConfigs = bracketConfigsMap.get(PayPeriod.WEEKLY);
        for (int i = 0; i < bracketConfigs.length; i++) {
            double taxRate = bracketConfigs[i].getTaxRate();
            double lowerBound = i > 0 ? bracketConfigs[i - 1].getMaxTaxable() : 0;
            double upperBound = bracketConfigs[i].getMaxTaxable();

            double fixedTax = i > 0 ? allBrackets[i - 1].getFixedTax() + (allBrackets[i - 1].getUpperBound() - allBrackets[i - 1].getLowerBound()) * allBrackets[i - 1].getTaxRate(): 0;
            TaxBracket taxBracket = new TaxBracket(taxRate, fixedTax, lowerBound, upperBound);
            allBrackets[i] = taxBracket;
        }

    }

    public static Map<PayPeriod, BracketConfig[]> getBracketConfigsMap() {
        return bracketConfigsMap;
    }

    public static Map<PayPeriod, Double> getAllowances() {
        return allowances;
    }

    public static TaxBracket[] getAllBrackets(){
        return allBrackets;
    }


}
