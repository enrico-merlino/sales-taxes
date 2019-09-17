package merlino.salestaxes;

import java.util.HashMap;
import java.util.Map;

import static merlino.salestaxes.Category.*;

public class Catalog
{
    Map<String, Product> _items = new HashMap<>();

    public Catalog() {
        _items.put("book", new Product("book", BOOKS));
        _items.put("chocolate bar", new Product("chocolate bar", FOOD));
    }

    public Product bySku(String itemSku)
    {
        return _items.containsKey(itemSku)
                ? _items.get(itemSku)
                : new Product(itemSku, OTHER);
    }
}
