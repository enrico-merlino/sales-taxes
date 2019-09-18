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
        Item item = new Item(new Product("any", new PercentTax("0.04")), "21.345");
        assertThat(item.tax(), is(new BigDecimal("0.85")));
    }
}
