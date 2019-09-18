package merlino.salestaxes;

import java.math.BigDecimal;

public abstract class Tax
{
    public BigDecimal taxFor(BigDecimal basePrice)
    {
        return taxPercent().multiply(basePrice);
    }

    protected abstract BigDecimal taxPercent();
}
