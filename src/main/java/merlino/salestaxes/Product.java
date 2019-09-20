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
    private Taxable[] _taxables;

    public Product(String sku, Category category, Origin origin)
    {
        _sku = sku;
        _taxables = new Taxable[] {category, origin};
    }

    public BigDecimal taxFor(BigDecimal currentPrice)
    {
        return sum(stream(_taxables).map(tax -> tax.taxFor(currentPrice)));
    }

    public String sku()
    {
        return _sku;
    }
}
