package net.paychecker.taxes.config;

import net.paychecker.PayPeriod;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ksenia Belikova
 * @version 2/11/17.
 */
public class FederalTaxConfig {
    private static Map<PayPeriod, BracketConfig[]> brackets = new HashMap<>();
    private static Map<PayPeriod, Double> allowances = new HashMap<>();

    static {
        brackets.put(PayPeriod.WEEKLY, new FederalBracketConfig[]{
                new FederalBracketConfig(43, 0),
                new FederalBracketConfig(222, 0.1),
                new FederalBracketConfig(767, 0.15),
                new FederalBracketConfig(1796, 0.25),
                new FederalBracketConfig(3700, 0.28),
                new FederalBracketConfig(7992, 0.33),
                new FederalBracketConfig(8025, 0.35),
                new FederalBracketConfig(Double.MAX_VALUE, 0.369)});

        brackets.put(PayPeriod.BIWEEKLY, new FederalBracketConfig[]{
                new FederalBracketConfig(87, 0),
                new FederalBracketConfig(443, 0.1),
                new FederalBracketConfig(1535, 0.15),
                new FederalBracketConfig(3592, 0.25),
                new FederalBracketConfig(7400, 0.28),
                new FederalBracketConfig(15985, 0.33),
                new FederalBracketConfig(16050, 0.35),
                new FederalBracketConfig(Double.MAX_VALUE, 0.369)});

        brackets.put(PayPeriod.SEMIMONTHLY, new FederalBracketConfig[]{
                new FederalBracketConfig(94, 0),
                new FederalBracketConfig(480, 0.1),
                new FederalBracketConfig(1663, 0.15),
                new FederalBracketConfig(3892, 0.25),
                new FederalBracketConfig(8017, 0.28),
                new FederalBracketConfig(17317, 0.33),
                new FederalBracketConfig(17388, 0.35),
                new FederalBracketConfig(Double.MAX_VALUE, 0.369)});

        brackets.put(PayPeriod.MONTHLY, new FederalBracketConfig[]{
                new FederalBracketConfig(188, 0),
                new FederalBracketConfig(960, 0.1),
                new FederalBracketConfig(3325, 0.15),
                new FederalBracketConfig(7783, 0.25),
                new FederalBracketConfig(16033, 0.28),
                new FederalBracketConfig(34633, 0.33),
                new FederalBracketConfig(34775, 0.35),
                new FederalBracketConfig(Double.MAX_VALUE, 0.369)});

        brackets.put(PayPeriod.ANNUALLY, new FederalBracketConfig[]{
                new FederalBracketConfig(2250, 0),
                new FederalBracketConfig(11525, 0.1),
                new FederalBracketConfig(39900, 0.15),
                new FederalBracketConfig(93400, 0.25),
                new FederalBracketConfig(192400, 0.28),
                new FederalBracketConfig(415600, 0.33),
                new FederalBracketConfig(417300, 0.35),
                new FederalBracketConfig(Double.MAX_VALUE, 0.369)});
    }

    static {
        allowances.put(PayPeriod.WEEKLY, 77.90);
        allowances.put(PayPeriod.BIWEEKLY, 155.80);
        allowances.put(PayPeriod.SEMIMONTHLY, 168.80);
        allowances.put(PayPeriod.MONTHLY, 337.50);
        allowances.put(PayPeriod.ANNUALLY, 4050.0);
    }

//    static {
//        for (int i = 0; i < brackets.get(PayPeriod.WEEKLY).length; i++) {
//            FederalTaxBracketHelper federalTaxBracketHelper = new FederalTaxBracketHelper(brackets.get(PayPeriod.WEEKLY)[i]
//            );
//        }
//
//    }
    public static Map<PayPeriod, BracketConfig[]> getBrackets() {
        return brackets;
    }

    public static Map<PayPeriod, Double> getAllowances() {
        return allowances;
    }

}
