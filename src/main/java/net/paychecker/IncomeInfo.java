package net.paychecker;

/**
 * @author Ksenia Belikova
 * @version 2/11/17.
 */
public class IncomeInfo {
    private double salary;
    private  int allowance;
    private PayPeriod payPeriod;

    public IncomeInfo(double salary, int allowance, PayPeriod payPeriod){
        this.salary = salary;
        this.allowance = allowance;
        this.payPeriod = payPeriod;
    }

    public double getSalary() {
        return salary;
    }

    public int getAllowance() {
        return allowance;
    }

    public PayPeriod getPayPeriod() {
        return payPeriod;
    }

}
