package merlino.salestaxes;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CashDesk
{
    BigDecimal _salesTaxes = BigDecimal.ZERO;

    public CashDesk add(String name, String category, String price)
    {
        if ("multimedia".equals(category))
        {
            _salesTaxes = _salesTaxes.add(new BigDecimal(price).multiply(new BigDecimal("0.1")));
        }
        return this;
    }

    public String salesTaxes()
    {
        return String.format("%,.2f", _salesTaxes.setScale(2, RoundingMode.HALF_UP));
    }
}
