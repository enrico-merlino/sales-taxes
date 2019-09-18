package merlino.salestaxes;

import java.util.ArrayList;
import java.util.List;

import static java.math.BigDecimal.ZERO;

public class CashDesk
{
    List<Item> _items = new ArrayList<>();

    public CashDesk add(String sku, String price)
    {
        _items.add(new Item(new Catalog().bySku(sku), price));
        return this;
    }

    public String salesTaxes()
    {
        return String.format("%,.2f",
                _items.stream()
                        .map(item -> item.tax())
                        .reduce(ZERO, (a, b) -> a.add(b)));
    }
}
