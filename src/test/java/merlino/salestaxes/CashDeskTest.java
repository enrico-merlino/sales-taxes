package merlino.salestaxes;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CashDeskTest
{
    @Test
    public void shouldApplySalesTaxesOnCorrectCategories()
    {
        CashDesk cashDesk = new CashDesk()
                .add("book", new Category("books"), "12.49")
                .add("music CD", new Category("multimedia"), "14.99")
                .add("chocolate bar", new Category("food"), "0.85");

        assertThat(cashDesk.salesTaxes(), is("1.50"));
    }
}