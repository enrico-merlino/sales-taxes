package merlino.salestaxes;

import java.math.BigDecimal;

public abstract class Tax
{
    public BigDecimal taxFor(BigDecimal basePrice)
    {
        return TaxPercent().multiply(basePrice);
    }

    protected abstract BigDecimal TaxPercent();
}