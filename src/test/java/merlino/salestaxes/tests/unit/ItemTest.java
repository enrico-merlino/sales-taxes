package merlino.salestaxes.tests.unit;

import merlino.salestaxes.Category;
import merlino.salestaxes.Item;
import merlino.salestaxes.tests.PercentTax;
import merlino.salestaxes.Product;
import org.junit.Test;

import java.math.BigDecimal;

import static merlino.salestaxes.Category.*;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ItemTest
{
    @Test
    public void shouldCalculateTax()
    {
        Item item = new Item(3, "109.99", new Product("any", ENTERTAINMENT, new PercentTax("0.105")));
        assertThat(item.tax(), is(new BigDecimal("67.65")));
    }

    @Test
    public void shouldCalculateFinalPrice()
    {
        Item item = new Item(2, "21.34", new Product("any", FOOD, new PercentTax("0.04")));
        assertThat(item.finalPrice(), is(new BigDecimal("44.48")));
    }

    @Test
    public void shouldDescribeItselfAsReceiptRow()
    {
        Item item = new Item(4, "199.99", new Product("phone", MEDICAL, new PercentTax("0.13")));
        assertThat(item.asReceiptRow(), is("4 phone: 903.96"));
    }
}
