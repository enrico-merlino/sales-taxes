package merlino.salestaxes;

import org.junit.Test;

import java.math.BigDecimal;

import static merlino.salestaxes.Category.FOOD;
import static merlino.salestaxes.Category.OTHER;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ProductTest
{
    @Test
    public void shouldCalculateTaxBasedOnCategory()
    {
        assertThat(new Product("any", OTHER).taxFor(new BigDecimal("24.49")), is(new BigDecimal("2.4490")));
        assertThat(new Product("any", FOOD).taxFor(new BigDecimal("24.49")), is(new BigDecimal("0.00")));
    }
}
