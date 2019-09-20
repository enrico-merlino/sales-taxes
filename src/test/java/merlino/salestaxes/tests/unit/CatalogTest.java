package merlino.salestaxes.tests.unit;

import merlino.salestaxes.Catalog;
import merlino.salestaxes.Product;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CatalogTest
{
    @Test
    public void shouldRetrieveCategoryByItemSku()
    {
        assertThat(new Catalog(new Product("the only product", null, null)).bySku("the only product").sku(),
                is("the only product"));
    }

    @Test(expected = Exception.class)
    public void shouldGiveDefaultCategoryOnUnknownItemSku()
    {
        new Catalog(new Product("the only product", null, null)).bySku("unknown");
    }
}
