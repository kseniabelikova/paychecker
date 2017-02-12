package net.paychecker;

/**
 * @author Ksenia Belikova
 * @version 2/11/17.
 */
public enum PayPeriod {
    WEEKLY("Weekly"), BIWEEKLY("Biweekly"), SEMIMONTHLY("Semimonthly"), MONTHLY("Monthly"), ANNUALLY("Annually");
    private String period;

    PayPeriod(String period) {
        this.period = period;
    }

    public static PayPeriod fromValue(String s) {
        for (PayPeriod p : PayPeriod.values()) {
            if (p.period.equalsIgnoreCase(s)) {
                return p;
            }
        }
        return null;
    }

    public String getPeriod() {
        return period;
    }
}
