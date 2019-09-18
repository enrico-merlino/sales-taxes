package merlino.salestaxes;

import org.junit.Test;

import java.math.BigDecimal;

import static java.math.BigDecimal.ZERO;
import static merlino.salestaxes.Category.OTHER;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ProductTest
{
    @Test
    public void shouldCalculateTaxBasedOnCategory()
    {
        assertThat(new Product("any", OTHER).taxFor(new BigDecimal("24.49")), is(new BigDecimal("2.4490")));
        assertThat(new Product("any").taxFor(new BigDecimal("24.49")), is(ZERO));
    }

    @Test
    public void shouldExposeSku()
    {
        assertThat(new Product("Sku 1234", null).sku(), is("Sku 1234"));
    }
}
