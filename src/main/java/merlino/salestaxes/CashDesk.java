package merlino.salestaxes;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CashDesk
{
    BigDecimal _salesTaxes = BigDecimal.ZERO;

    public CashDesk add(String name, Category category, String price)
    {
        _salesTaxes = _salesTaxes.add(category.taxFor(new BigDecimal(price)));
        return this;
    }

    public String salesTaxes()
    {
        return String.format("%,.2f", _salesTaxes.setScale(2, RoundingMode.HALF_UP));
    }
}
