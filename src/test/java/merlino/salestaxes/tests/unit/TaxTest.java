package merlino.salestaxes.tests.unit;

import merlino.salestaxes.tests.PercentTax;
import org.junit.Test;

import java.math.BigDecimal;

import static java.math.BigDecimal.ONE;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TaxTest
{
    @Test
    public void shouldRoundToNearestTwentieth()
    {
        assertThat(new PercentTax("0.0000").taxFor(ONE), is(new BigDecimal("0.00")));
        assertThat(new PercentTax("0.0001").taxFor(ONE), is(new BigDecimal("0.05")));
        assertThat(new PercentTax("0.0499").taxFor(ONE), is(new BigDecimal("0.05")));
        assertThat(new PercentTax("0.0500").taxFor(ONE), is(new BigDecimal("0.05")));
        assertThat(new PercentTax("0.0501").taxFor(ONE), is(new BigDecimal("0.10")));
        assertThat(new PercentTax("0.0999").taxFor(ONE), is(new BigDecimal("0.10")));
        assertThat(new PercentTax("0.1000").taxFor(ONE), is(new BigDecimal("0.10")));
    }
}
