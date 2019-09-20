package merlino.salestaxes.tests.unit;

import merlino.salestaxes.ImportDuty;
import merlino.salestaxes.Product;
import org.junit.Test;

import java.math.BigDecimal;

import static java.math.BigDecimal.ZERO;
import static merlino.salestaxes.Category.*;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ProductTest
{
    @Test
    public void shouldCalculateTaxForExemptProduct()
    {
        assertThat(new Product("any", FOOD).taxFor(new BigDecimal("24.49")), is(ZERO));
    }

    @Test
    public void shouldCalculateTaxForSingleTax()
    {
        assertThat(new Product("any", ENTERTAINMENT).taxFor(new BigDecimal("24.49")), is(new BigDecimal("2.45")));
    }

    @Test
    public void shouldCalculateTaxForMultipleTaxes()
    {
        assertThat(new Product("any", FASHION, new ImportDuty()).taxFor(new BigDecimal("24.49")), is(new BigDecimal("3.70")));
    }
}
