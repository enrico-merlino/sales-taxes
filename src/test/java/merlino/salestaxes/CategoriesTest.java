package merlino.salestaxes;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CategoriesTest
{
    @Test
    public void shouldRetrieveCategoryByItemSku() {
        assertThat(new Categories().bySku("book").id(), is("books"));
        assertThat(new Categories().bySku("chocolate bar").id(), is("food"));
    }

    @Test
    public void shouldGiveDefaultCategoryOnUnknownItemSku() {
        assertThat(new Categories().bySku("unknown").id(), is("other"));
        assertThat(new Categories().bySku("music CD").id(), is("other"));
    }
}
