package merlino.salestaxes;

import java.math.BigDecimal;

import static java.math.RoundingMode.UP;

public abstract class Tax
{
    private static final BigDecimal FIVE = new BigDecimal("5");
    private static final BigDecimal HUNDRED = new BigDecimal("100");

    public BigDecimal taxFor(BigDecimal basePrice)
    {
        return round(taxPercent().multiply(basePrice));
    }

    private BigDecimal round(BigDecimal value)
    {
        return value
                .multiply(HUNDRED)
                .divide(FIVE)
                .setScale(0, UP)
                .multiply(FIVE)
                .setScale(2)
                .divide(HUNDRED);
    }

    protected abstract BigDecimal taxPercent();
}
