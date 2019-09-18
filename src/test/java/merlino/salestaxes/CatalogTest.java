package merlino.salestaxes;

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

    @Test
    public void shouldGiveDefaultCategoryOnUnknownItemSku()
    {
        assertThat(new Catalog().bySku("unknown").sku(), is("unknown"));
        assertThat(new Catalog().bySku("music CD").sku(), is("music CD"));
    }
}
