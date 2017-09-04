package net.paychecker.taxes.config.stateTaxConfigs;

import net.paychecker.PayPeriod;
import net.paychecker.taxes.config.BracketConfig;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ksenia Belikova
 * @version 2/13/17.
 */
public class VirginiaStateTaxConfig {

    private static Map<PayPeriod, BracketConfig[]> virginiaBracketConfigsMap = new HashMap<>();
    private static Map<PayPeriod, Double> allowances = new HashMap<>();

    static {
        virginiaBracketConfigsMap.put(PayPeriod.ANNUALLY, new BracketConfig[]{
                new BracketConfig(3000, 0.02),
                new BracketConfig(5000, 0.03),
                new BracketConfig(17000, 0.05),
                new BracketConfig(Double.MAX_VALUE, 0.0575)});
    }

}
