package merlino.salestaxes;

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
        assertThat(new PercentTax("0.00").taxFor(ONE), is(new BigDecimal("0.00")));
        assertThat(new PercentTax("0.01").taxFor(ONE), is(new BigDecimal("0.00")));
        assertThat(new PercentTax("0.02").taxFor(ONE), is(new BigDecimal("0.00")));
        assertThat(new PercentTax("0.024").taxFor(ONE), is(new BigDecimal("0.00")));
        assertThat(new PercentTax("0.025").taxFor(ONE), is(new BigDecimal("0.05")));
        assertThat(new PercentTax("0.03").taxFor(ONE), is(new BigDecimal("0.05")));
        assertThat(new PercentTax("0.04").taxFor(ONE), is(new BigDecimal("0.05")));
        assertThat(new PercentTax("0.05").taxFor(ONE), is(new BigDecimal("0.05")));
        assertThat(new PercentTax("0.06").taxFor(ONE), is(new BigDecimal("0.05")));
        assertThat(new PercentTax("0.07").taxFor(ONE), is(new BigDecimal("0.05")));
        assertThat(new PercentTax("0.074").taxFor(ONE), is(new BigDecimal("0.05")));
        assertThat(new PercentTax("0.075").taxFor(ONE), is(new BigDecimal("0.10")));
        assertThat(new PercentTax("0.08").taxFor(ONE), is(new BigDecimal("0.10")));
        assertThat(new PercentTax("0.09").taxFor(ONE), is(new BigDecimal("0.10")));
        assertThat(new PercentTax("0.10").taxFor(ONE), is(new BigDecimal("0.10")));
    }
}
