package net.paychecker;

import net.paychecker.taxes.config.FederalTaxConfig;
import net.paychecker.taxes.config.TaxBracket;
import org.junit.Test;

/**
 * @author Ksenia Belikova
 * @version 2/5/17.
 */
public class FederalTaxBracketHelperTest {
    @Test
    public void testFindBrackets() {
        for (TaxBracket t :
                FederalTaxConfig.getAllBrackets().get(PayPeriod.WEEKLY)) {
            System.out.println(t.getFixedTax());
            System.out.println(t.getLowerBound());
            System.out.println(t.getUpperBound());
            System.out.println(t.getTaxRate());
            System.out.println();
        }
        ;

        //  FederalTaxBracketHelper bracket;
        //  bracket = FederalTaxBracketHelper.findBracket(0,"Annually");
        //  Assert.assertEquals(0, bracket.getFixedTax(), 0);
        //  Assert.assertEquals(2250, bracket.getStartBracketAmount(), 0);
        //  Assert.assertEquals(0, bracket.getTaxRate(), 0);

        //  bracket = FederalTaxBracketHelper.findBracket(10000,"Annually");
        //  Assert.assertEquals(0, bracket.getFixedTax(), 0);
        //  Assert.assertEquals(11525, bracket.getStartBracketAmount(), 0);
        //  Assert.assertEquals(0.1, bracket.getTaxRate(), 0);

        //  bracket = FederalTaxBracketHelper.findBracket(35900, "Annually");
        //  Assert.assertEquals(927.50, bracket.getFixedTax(), 0);
        //  Assert.assertEquals(39900, bracket.getStartBracketAmount(), 0);
        //  Assert.assertEquals(0.15, bracket.getTaxRate(), 0);

        //  bracket = FederalTaxBracketHelper.findBracket(80600, "Annually");
        //  Assert.assertEquals(5183.75, bracket.getFixedTax(), 0);
        //  Assert.assertEquals(93400, bracket.getStartBracketAmount(), 0);
        //  Assert.assertEquals(0.25, bracket.getTaxRate(), 0);

        //  bracket = FederalTaxBracketHelper.findBracket(159075, "Annually");
        //  Assert.assertEquals(18558.75, bracket.getFixedTax(), 0);
        //  Assert.assertEquals(192400, bracket.getStartBracketAmount(), 0);
        //  Assert.assertEquals(0.28, bracket.getTaxRate(), 0);

        //  bracket = FederalTaxBracketHelper.findBracket(415400, "Annually");
        //  Assert.assertEquals(46278.75, bracket.getFixedTax(), 0);
        //  Assert.assertEquals(415600, bracket.getStartBracketAmount(), 0);
        //  Assert.assertEquals(0.33, bracket.getTaxRate(), 0);

        //  bracket = FederalTaxBracketHelper.findBracket(415999, "Annually");
        //  Assert.assertEquals(119934.75, bracket.getFixedTax(), 0);
        //  Assert.assertEquals(417300, bracket.getStartBracketAmount(), 0);
        //  Assert.assertEquals(0.35, bracket.getTaxRate(), 0);

        //  bracket = FederalTaxBracketHelper.findBracket(5000000, "Annually");
        //  Assert.assertEquals(120529.75, bracket.getFixedTax(), 0);
        //  Assert.assertEquals(Double.MAX_VALUE, bracket.getStartBracketAmount(), 0);
        //  Assert.assertEquals(0.369, bracket.getTaxRate(), 0);
    }
}
