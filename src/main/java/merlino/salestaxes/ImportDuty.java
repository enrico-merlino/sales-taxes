package merlino.salestaxes;

import java.math.BigDecimal;

public class ImportDuty extends Tax
{
    @Override
    protected BigDecimal taxPercent()
    {
        return new BigDecimal("0.05");
    }
}
