package merlino.salestaxes;

import java.util.ArrayList;
import java.util.List;

import static merlino.salestaxes.BigDecimalUtils.sum;

public class CashDesk
{
    List<Item> _items = new ArrayList<>();

    public CashDesk add(String sku, String price)
    {
        _items.add(new Item(price, new Catalog().bySku(sku)));
        return this;
    }

    public String salesTaxes()
    {
        return String.format("%,.2f", sum(_items.stream().map(item -> item.tax())));
    }
}
