package merlino.salestaxes;

import java.math.BigDecimal;

public class Item
{
    private Product _product;
    private BigDecimal _price;

    public Item(Product product, String price)
    {
        _product = product;
        _price = new BigDecimal(price);
    }

    public BigDecimal tax()
    {
        return _product.taxFor(_price);
    }
}
