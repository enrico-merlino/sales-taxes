package merlino.salestaxes;

import java.math.BigDecimal;

public class Category extends Tax
{
    private static final BigDecimal ONE_TENTH = new BigDecimal("0.10");

    public static final Category OTHER = new Category(ONE_TENTH);

    private BigDecimal _taxPercent;

    private Category(BigDecimal taxPercent)
    {
        _taxPercent = taxPercent;
    }

    @Override
    protected BigDecimal TaxPercent()
    {
        return _taxPercent;
    }
}
