package merlino.salestaxes.tests.unit;

import merlino.salestaxes.Item;
import merlino.salestaxes.Product;
import org.junit.Test;

import java.math.BigDecimal;

import static merlino.salestaxes.Category.*;
import static merlino.salestaxes.Origin.IMPORTED;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ItemTest
{
    @Test
    public void shouldCalculateTax()
    {
        Item item = new Item(3, "109.99", new Product("any", ENTERTAINMENT, IMPORTED));
        assertThat(item.tax(), is(new BigDecimal("49.50")));
    }

    @Test
    public void shouldCalculateFinalPrice()
    {
        Item item = new Item(2, "21.34", new Product("any", FOOD, IMPORTED));
        assertThat(item.finalPrice(), is(new BigDecimal("44.88")));
    }

    @Test
    public void shouldDescribeItselfAsReceiptRow()
    {
        Item item = new Item(4, "199.99", new Product("phone", MEDICAL, IMPORTED));
        assertThat(item.asReceiptRow(), is("4 phone: 839.96"));
    }
}
