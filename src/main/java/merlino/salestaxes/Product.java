package merlino.salestaxes;

import java.math.BigDecimal;

import static java.util.Arrays.stream;
import static merlino.salestaxes.BigDecimalUtils.sum;

public class Product
{
    private String _sku;
    private Tax[] _taxes;

    public Product(String sku, Tax... taxes)
    {
        _sku = sku;
        _taxes = taxes;
    }

    public BigDecimal taxFor(BigDecimal currentPrice)
    {
        return sum(stream(_taxes).map(tax -> tax.taxFor(currentPrice)));
    }

    public String sku()
    {
        return _sku;
    }
}
