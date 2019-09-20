package merlino.salestaxes;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toList;
import static merlino.salestaxes.BigDecimalUtils.sum;

public class Product
{
    private String _sku;
    private List<Taxable> _taxables;

    public Product(String sku, Category category, Taxable... taxables)
    {
        _sku = sku;
        _taxables = new ArrayList<>();
        _taxables.add(category);
        _taxables.addAll(stream(taxables).collect(toList()));
    }

    public BigDecimal taxFor(BigDecimal currentPrice)
    {
        return sum(_taxables.stream().map(tax -> tax.taxFor(currentPrice)));
    }

    public String sku()
    {
        return _sku;
    }
}
