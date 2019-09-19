package merlino.salestaxes.tests.unit;

import merlino.salestaxes.Catalog;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CatalogTest
{
    @Test
    public void shouldRetrieveCategoryByItemSku()
    {
        assertThat(new Catalog().bySku("book").sku(), is("book"));
        assertThat(new Catalog().bySku("chocolate bar").sku(), is("chocolate bar"));
    }

    @Test(expected = Exception.class)
    public void shouldGiveDefaultCategoryOnUnknownItemSku()
    {
        new Catalog().bySku("unknown");
    }
}
