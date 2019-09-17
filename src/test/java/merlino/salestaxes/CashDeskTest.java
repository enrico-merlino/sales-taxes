package merlino.salestaxes;

import org.junit.Test;

import static merlino.salestaxes.Category.*;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CashDeskTest
{
    @Test
    public void shouldApplySalesTaxesOnCorrectCategories()
    {
        CashDesk cashDesk = new CashDesk()
                .add("book", BOOKS, "12.49")
                .add("music CD", MULTIMEDIA, "14.99")
                .add("chocolate bar", FOOD, "0.85");

        assertThat(cashDesk.salesTaxes(), is("1.50"));
    }
}
