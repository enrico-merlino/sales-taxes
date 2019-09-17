package merlino.salestaxes;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CatalogTest
{
    @Test
    public void shouldRetrieveCategoryByItemSku() {
        assertThat(new Catalog().bySku("book").category().id(), is("books"));
        assertThat(new Catalog().bySku("chocolate bar").category().id(), is("food"));
    }

    @Test
    public void shouldGiveDefaultCategoryOnUnknownItemSku() {
        assertThat(new Catalog().bySku("unknown").category().id(), is("other"));
        assertThat(new Catalog().bySku("music CD").category().id(), is("other"));
    }
}
