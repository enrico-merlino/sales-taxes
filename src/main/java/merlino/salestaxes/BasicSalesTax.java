package merlino.salestaxes;

import java.math.BigDecimal;

public class BasicSalesTax extends Tax
{
    @Override
    protected BigDecimal taxPercent()
    {
        return new BigDecimal("0.10");
    }
}
