package merlino.salestaxes;

import java.math.BigDecimal;

public class PercentTax extends Tax
{
    private BigDecimal _percent;

    public PercentTax(String percent)
    {
        _percent = new BigDecimal(percent);
    }

    @Override
    protected BigDecimal taxPercent()
    {
        return _percent;
    }
}
