package merlino.salestaxes;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.joining;
import static merlino.salestaxes.BigDecimalUtils.format;
import static merlino.salestaxes.BigDecimalUtils.sum;

public class CashDesk
{
    List<Item> _items = new ArrayList<>();
    Catalog _catalog;

    public CashDesk(Catalog catalog)
    {
        _catalog = catalog;
    }

    public CashDesk add(int quantity, String sku, String price)
    {
        _items.add(new Item(quantity, price, _catalog.bySku(sku)));
        return this;
    }

    public String receipt()
    {
        return String.join("\n",
                items(),
                "Sales Taxes: " + format(totalTaxes()),
                "Total: " + format(total()));
    }

    private String items()
    {
        return _items.stream()
                .map(item -> item.asReceiptRow())
                .collect(joining("\n"));
    }

    private BigDecimal totalTaxes()
    {
        return sum(_items.stream().map(item -> item.tax()));
    }

    private BigDecimal total()
    {
        return sum(_items.stream().map(item -> item.finalPrice()));
    }
}
