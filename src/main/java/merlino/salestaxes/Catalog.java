package merlino.salestaxes;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toList;

public class Catalog
{
    Product[] _products = new Product[]
            {
                    new Product("book"),
                    new Product("chocolate bar"),
                    new Product("music CD", new BasicSalesTax())
            };

    public Product bySku(final String itemSku)
    {
        return stream(_products)
                .filter(product -> product.sku().equals(itemSku))
                .collect(toList())
                .get(0);
    }
}
