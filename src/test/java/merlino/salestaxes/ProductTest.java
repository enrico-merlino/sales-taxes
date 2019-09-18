package merlino.salestaxes;

import org.junit.Test;

import java.math.BigDecimal;

import static java.math.BigDecimal.ZERO;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ProductTest
{
    @Test
    public void shouldCalculateTaxForExemptProduct()
    {
        assertThat(new Product("any").taxFor(new BigDecimal("24.49")), is(ZERO));
    }

    @Test
    public void shouldCalculateTaxForSingleTax()
    {
        assertThat(new Product("any", new BasicSalesTax()).taxFor(new BigDecimal("24.49")), is(new BigDecimal("2.4490")));
    }

    @Test
    public void shouldCalculateTaxForMultipleTaxes()
    {
        assertThat(new Product("any", new BasicSalesTax(), new BasicSalesTax()).taxFor(new BigDecimal("24.49")), is(new BigDecimal("4.8980")));
    }
}
