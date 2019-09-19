package merlino.salestaxes;

import org.junit.Test;

import java.math.BigDecimal;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ItemTest
{
    @Test
    public void shouldCalculateTax()
    {
        Item item = new Item("109.99", new Product("any", new PercentTax("0.087"), new PercentTax("0.105")));
        assertThat(item.tax(), is(new BigDecimal("21.15")));
    }

    @Test
    public void shouldCalculateFinalPrice()
    {
        Item item = new Item("21.34", new Product("any", new PercentTax("0.04")));
        assertThat(item.finalPrice(), is(new BigDecimal("22.24")));
    }
}
