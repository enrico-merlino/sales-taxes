package merlino.salestaxes;

import java.math.BigDecimal;

import static merlino.salestaxes.BigDecimalUtils.format;

public class Item
{
    private int _quantity;
    private Product _product;
    private BigDecimal _preTaxPrice;

    public Item(int quantity, String preTaxPrice, Product product)
    {
        _quantity = quantity;
        _product = product;
        _preTaxPrice = new BigDecimal(preTaxPrice);
    }

    public BigDecimal tax()
    {
        return _product.taxFor(_preTaxPrice).multiply(new BigDecimal(_quantity));
    }

    public BigDecimal finalPrice()
    {
        return tax().add(_preTaxPrice.multiply(new BigDecimal(_quantity)));
    }

    public String asReceiptRow()
    {
        return String.join(" ",
                String.valueOf(_quantity), _product.sku() + ":", format(finalPrice()));
    }
}
