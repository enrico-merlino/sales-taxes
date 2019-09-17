package merlino.salestaxes;

import java.math.BigDecimal;

public class Product
{
    private Category _category;

    public Product(String sku, Category category)
    {
        _category = category;
    }

    public Category category()
    {
        return _category;
    }

    public BigDecimal taxFor(BigDecimal currentPrice)
    {
        return _category.taxFor(currentPrice);
    }
}
