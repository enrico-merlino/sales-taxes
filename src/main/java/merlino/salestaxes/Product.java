package merlino.salestaxes;

import java.math.BigDecimal;

public class Product
{
    private String _sku;
    private Tax _tax;

    public Product(String sku, Tax tax)
    {
        _sku = sku;
        _tax = tax;
    }

    public BigDecimal taxFor(BigDecimal currentPrice)
    {
        return _tax.taxFor(currentPrice);
    }

    public String sku()
    {
        return _sku;
    }
}
