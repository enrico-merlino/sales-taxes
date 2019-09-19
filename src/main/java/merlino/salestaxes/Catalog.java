package merlino.salestaxes;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toList;

public class Catalog
{
    Product[] _products;

    public Catalog(Product ... products)
    {
        _products = products;
    }

    public Product bySku(final String itemSku)
    {
        return stream(_products)
                .filter(product -> product.sku().equals(itemSku))
                .collect(toList())
                .get(0);
    }
}
