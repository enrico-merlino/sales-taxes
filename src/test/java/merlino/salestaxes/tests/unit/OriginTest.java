package merlino.salestaxes.tests.unit;

import merlino.salestaxes.Origin;
import org.junit.Test;

import java.math.BigDecimal;

import static java.math.BigDecimal.TEN;
import static java.math.BigDecimal.ZERO;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class OriginTest
{
    @Test
    public void shouldNotApplyTaxOnExentCategories() {
        assertThat(Origin.NATIONAL.taxFor(TEN), is(ZERO));
    }

    @Test
    public void shouldApplyTaxOnTaxableCategories() {
        assertThat(Origin.IMPORTED.taxFor(new BigDecimal("20.34")), is(new BigDecimal("1.05")));
    }
}
