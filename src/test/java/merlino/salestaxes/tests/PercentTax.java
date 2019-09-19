package merlino.salestaxes.tests;

import merlino.salestaxes.Tax;

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
