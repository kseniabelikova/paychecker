package net.paychecker.taxes;

import net.paychecker.InputInfo;
import net.paychecker.TaxResult;

/**
 * @author Ksenia Belikova
 * @version 2/11/17.
 */
public interface Tax {
    TaxResult calc(InputInfo inputInfo);
    String getName();
}
