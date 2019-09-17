package merlino.salestaxes;

import java.math.BigDecimal;

import static java.math.BigDecimal.ZERO;

public class Category
{
    String _name;

    public Category(String name)
    {
        _name = name;
    }

    public BigDecimal taxFor(BigDecimal basePrice)
    {
        return "multimedia".equals(_name)
                ? basePrice.multiply(new BigDecimal("0.10"))
                : ZERO;
    }
}
