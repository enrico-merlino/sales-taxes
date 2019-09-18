package merlino.salestaxes;

import java.math.BigDecimal;

import static merlino.salestaxes.BigDecimalUtils.format;

public class Item
{
    private Product _product;
    private BigDecimal _preTaxPrice;

    public Item(String preTaxPrice, Product product)
    {
        _product = product;
        _preTaxPrice = new BigDecimal(preTaxPrice);
    }

    public BigDecimal tax()
    {
        return _product.taxFor(_preTaxPrice);
    }

    public BigDecimal finalPrice()
    {
        return tax().add(_preTaxPrice);
    }

    public String asReceiptRow()
    {
        return String.join(" ", "1", _product.sku() + ":", format(finalPrice()));
    }
}
