package merlino.salestaxes;

import java.util.HashMap;
import java.util.Map;

import static merlino.salestaxes.Category.*;

public class Categories
{
    Map<String,Category> _items = new HashMap<>();

    public Categories() {
        _items.put("book", BOOKS);
        _items.put("music CD", MULTIMEDIA);
        _items.put("chocolate bar", FOOD);
    }

    public Category bySku(String itemSku)
    {
        return _items.get(itemSku);
    }
}
