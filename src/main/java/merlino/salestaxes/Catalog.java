package merlino.salestaxes;

import java.util.List;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toList;
import static merlino.salestaxes.Category.*;

public class Catalog
{
    Product[] _products = new Product[]
            {
                    new Product("book"),
                    new Product("chocolate bar")
            };

    public Product bySku(final String itemSku)
    {
        List<Product> filtered = stream(_products)
                .filter(product -> product.sku().equals(itemSku))
                .collect(toList());

        return filtered.size() > 0
                ? filtered.get(0)
                : new Product(itemSku, OTHER);
    }
}
