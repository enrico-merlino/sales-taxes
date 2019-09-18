package merlino.salestaxes;

import java.math.BigDecimal;
import java.util.Arrays;

import static java.math.BigDecimal.ZERO;

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
        return Arrays.stream(_taxes)
                .map(tax -> tax.taxFor(currentPrice))
                .reduce(ZERO, (a, b) -> a.add(b));
    }

    public String sku()
    {
        return _sku;
    }
}
